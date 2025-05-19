package com.Skylinker.util;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Utility class for encrypting and decrypting passwords using AES-GCM.
 * The encryption key is derived from the combination of a fixed application secret and the user's email,
 * using PBKDF2 with HMAC SHA-256.
 */
public class PasswordUtil {
    private static final Logger logger = Logger.getLogger(PasswordUtil.class.getName());
    
    private static final String ENCRYPT_ALGO = "AES/GCM/NoPadding";
    private static final int TAG_LENGTH_BIT = 128;
    private static final int IV_LENGTH_BYTE = 12;
    private static final int SALT_LENGTH_BYTE = 16;
    private static final Charset UTF_8 = StandardCharsets.UTF_8;
    
    // Fixed secret to combine with email for stronger key derivation
    private static final String APPLICATION_SECRET = "YourAppSecret123!";

    /**
     * Generates a random nonce of specified byte length.
     * 
     * @param numBytes number of bytes for the nonce
     * @return byte array containing random nonce
     */
    public static byte[] getRandomNonce(int numBytes) {
        byte[] nonce = new byte[numBytes];
        new SecureRandom().nextBytes(nonce);
        return nonce;
    }

    /**
     * Derives an AES 256-bit key using PBKDF2 with HMAC SHA-256 from the combined application secret and email.
     * 
     * @param email the user's email used as part of the key derivation salt
     * @param salt  the random salt used in key derivation
     * @return the generated SecretKey or null if key generation fails
     */
    private static SecretKey getAESKeyFromEmail(String email, byte[] salt) {
        try {
            String keyMaterial = APPLICATION_SECRET + email;
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            KeySpec spec = new PBEKeySpec(keyMaterial.toCharArray(), salt, 65536, 256);
            return new SecretKeySpec(factory.generateSecret(spec).getEncoded(), "AES");
        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
            logger.log(Level.SEVERE, "Failed to generate AES key from email", ex);
            return null;
        }
    }

    /**
     * Encrypts a plaintext password using AES-GCM with a key derived from the user's email.
     * The output contains the IV, salt, and ciphertext concatenated and Base64-encoded.
     * 
     * @param email    the user's email used for key derivation; must not be null
     * @param password the plaintext password to encrypt; must not be null
     * @return Base64-encoded string containing IV + salt + ciphertext, or null on failure
     */
    public static String encrypt(String email, String password) {
        try {
            if (email == null || password == null) {
                logger.warning("Email or password is null during encryption");
                return null;
            }

            byte[] salt = getRandomNonce(SALT_LENGTH_BYTE);
            byte[] iv = getRandomNonce(IV_LENGTH_BYTE);

            SecretKey aesKey = getAESKeyFromEmail(email, salt);
            if (aesKey == null) {
                logger.warning("Failed to generate AES key during encryption");
                return null;
            }

            Cipher cipher = Cipher.getInstance(ENCRYPT_ALGO);
            cipher.init(Cipher.ENCRYPT_MODE, aesKey, new GCMParameterSpec(TAG_LENGTH_BIT, iv));

            byte[] cipherText = cipher.doFinal(password.getBytes(UTF_8));

            byte[] cipherTextWithIvSalt = ByteBuffer.allocate(iv.length + salt.length + cipherText.length)
                    .put(iv)
                    .put(salt)
                    .put(cipherText)
                    .array();

            return Base64.getEncoder().encodeToString(cipherTextWithIvSalt);
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Encryption failed", ex);
            return null;
        }
    }

    /**
     * Decrypts a Base64-encoded string containing IV + salt + ciphertext into the original plaintext password.
     * The decryption key is derived using the user's email and the salt.
     * 
     * @param encryptedPassword the Base64 encoded string containing IV, salt, and ciphertext; must not be null
     * @param email             the user's email used for key derivation; must not be null
     * @return the decrypted plaintext password, or null on failure
     */
    public static String decrypt(String encryptedPassword, String email) {
        try {
            if (encryptedPassword == null || email == null) {
                logger.warning("Encrypted password or email is null during decryption");
                return null;
            }

            byte[] decode = Base64.getDecoder().decode(encryptedPassword.getBytes(UTF_8));
            ByteBuffer bb = ByteBuffer.wrap(decode);

            byte[] iv = new byte[IV_LENGTH_BYTE];
            bb.get(iv);

            byte[] salt = new byte[SALT_LENGTH_BYTE];
            bb.get(salt);

            byte[] cipherText = new byte[bb.remaining()];
            bb.get(cipherText);

            SecretKey aesKey = getAESKeyFromEmail(email, salt);
            if (aesKey == null) {
                logger.warning("Failed to generate AES key during decryption");
                return null;
            }

            Cipher cipher = Cipher.getInstance(ENCRYPT_ALGO);
            cipher.init(Cipher.DECRYPT_MODE, aesKey, new GCMParameterSpec(TAG_LENGTH_BIT, iv));

            byte[] plainText = cipher.doFinal(cipherText);
            return new String(plainText, UTF_8);
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Decryption failed for email: " + email, ex);
            return null;
        }
    }
}
