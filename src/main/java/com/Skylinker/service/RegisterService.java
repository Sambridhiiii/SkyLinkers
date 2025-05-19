package com.Skylinker.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.Skylinker.config.DbConfig;
import com.Skylinker.model.CustomerModel;
import com.Skylinker.util.PasswordUtil;

/**
 * RegisterService manages customer registration,
 * including database insertion with password encryption.
 */
public class RegisterService {
    private Connection connection;

    /**
     * Initializes RegisterService by establishing a database connection.
     *
     * @throws SQLException if a database access error occurs
     * @throws ClassNotFoundException if JDBC driver class is not found
     * @throws IllegalStateException if the database connection cannot be established
     */
    public RegisterService() throws SQLException, ClassNotFoundException {
        this.connection = DbConfig.getDbConnection();
        if (this.connection == null) {
            throw new IllegalStateException("Failed to establish database connection");
        }
    }

    /**
     * Registers a new customer by inserting their details into the database.
     * Passwords are encrypted before storage.
     *
     * @param customerModel the customer data to be registered
     * @return true if registration is successful; false otherwise
     * @throws RuntimeException if a database error or other exception occurs during registration
     */
    public Boolean registerCustomer(CustomerModel customerModel) {
        String insertQuery = "INSERT INTO customer (First_name, Last_name, Email_address, Phone_number, Create_password) "
                           + "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement insertStmt = connection.prepareStatement(insertQuery)) {
            // Encrypt the password using email as key or salt
            String encryptedPassword = PasswordUtil.encrypt(customerModel.getEmail(), customerModel.getCreate());
            
            insertStmt.setString(1, customerModel.getFirstname());
            insertStmt.setString(2, customerModel.getLastname());
            insertStmt.setString(3, customerModel.getEmail());
            insertStmt.setString(4, customerModel.getPhone());
            insertStmt.setString(5, encryptedPassword);

            int rowsInserted = insertStmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Database error during registration", e);
        } catch (Exception e) {
            throw new RuntimeException("Registration processing failed", e);
        }
    }
}
