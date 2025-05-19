package com.Skylinker.util;

/**
 * Utility class for validating common input fields such as names, emails,
 * phone numbers, and passwords.
 * 
 * LMU ID: 23048681  
 * NAME: Sambridhi Shrestha
 */
public class ValidationUtil {

    /**
     * Validates a first name.
     * Only letters (including Unicode letters) allowed, length 2 to 50.
     * 
     * @param firstName the first name to validate
     * @return true if valid; false otherwise
     */
    public static boolean isValidFirstName(String firstName) {
        return firstName != null && firstName.matches("^[\\p{L}]{2,50}$");
    }

    /**
     * Validates a last name.
     * Only letters (including Unicode letters) allowed, length 2 to 50.
     * 
     * @param lastName the last name to validate
     * @return true if valid; false otherwise
     */
    public static boolean isValidLastName(String lastName) {
        return lastName != null && lastName.matches("^[\\p{L}]{2,50}$");
    }

    /**
     * Validates an email address.
     * Must follow a typical email format.
     * 
     * @param email the email address to validate
     * @return true if valid; false otherwise
     */
    public static boolean isValidEmail(String email) {
        return email != null && email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
    }

    /**
     * Validates a phone number.
     * Must be exactly 10 digits.
     * 
     * @param phone the phone number to validate
     * @return true if valid; false otherwise
     */
    public static boolean isValidPhoneNumber(String phone) {
        return phone != null && phone.matches("^\\d{10}$");
    }

    /**
     * Validates a password.
     * Must be at least 8 characters and include at least one uppercase letter,
     * one lowercase letter, one digit, and one special character.
     * 
     * @param password the password to validate
     * @return true if valid; false otherwise
     */
    public static boolean isValidPassword(String password) {
        String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        return password != null && password.matches(passwordRegex);
    }

    /**
     * Checks if two passwords match exactly.
     * 
     * @param password        the first password
     * @param confirmPassword the second password to compare
     * @return true if both passwords are equal and non-null; false otherwise
     */
    public static boolean doPasswordsMatch(String password, String confirmPassword) {
        return password != null && password.equals(confirmPassword);
    }

    /**
     * Checks if a string is null or empty after trimming whitespace.
     * 
     * @param value the string to check
     * @return true if null or empty; false otherwise
     */
    public static boolean isNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
}
