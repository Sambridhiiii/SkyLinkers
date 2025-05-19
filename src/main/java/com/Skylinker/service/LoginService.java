package com.Skylinker.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Skylinker.config.DbConfig;
import com.Skylinker.model.CustomerModel;
import com.Skylinker.util.PasswordUtil;

/**
 * LoginService handles the authentication of customers.
 * It manages database connections and verifies user credentials.
 */
public class LoginService {
    private Connection dbConn;
    private boolean isConnectionError = false;

    /**
     * Initializes the LoginService and establishes a database connection.
     * Sets a flag if the connection fails.
     */
    public LoginService() {
        try {
            dbConn = DbConfig.getDbConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
            isConnectionError = true;
        }
    }

    /**
     * Authenticates a user by checking the provided credentials against the database.
     *
     * @param customerModel the CustomerModel containing email and password to verify
     * @return Boolean TRUE if authentication is successful,
     *         FALSE if credentials do not match,
     *         NULL if there is a connection error or SQL exception
     */
    public Boolean loginUser(CustomerModel customerModel) {
        if (isConnectionError) {
            System.out.println("Connection Error!");
            return null;
        }

        // SQL query to get email and encrypted password from the database
        String query = "SELECT Email_address, Create_password FROM customer WHERE Email_address = ?";
        try (PreparedStatement stmt = dbConn.prepareStatement(query)) {
            stmt.setString(1, customerModel.getEmail());
            ResultSet result = stmt.executeQuery();

            if (result.next()) {
                String dbEmail = result.getString("Email_address");
                String dbPassword = result.getString("Create_password");
                
                // Decrypt the stored password and compare with input
                String decryptedPassword = PasswordUtil.decrypt(dbPassword, dbEmail);
                return decryptedPassword != null && decryptedPassword.equals(customerModel.getCreate());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return false;
    }
}
