package com.Skylinker.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.Skylinker.config.DbConfig;
import com.Skylinker.model.CustomerModel;

public class RegisterService {

    private Connection connection;

    public RegisterService() {
        try {
            this.connection = DbConfig.getDbConnection();
            if (this.connection != null) {
                System.out.println("Database connected successfully.");
            } else {
                System.out.println("Connection is null.");
            }
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Database connection failed.");
            e.printStackTrace();
        }
    }

    public Boolean registerCustomer(CustomerModel customerModel) {
        if (this.connection == null) {
            System.out.println("Database did not connect");
            return false;
        }

        String insertQuery = "INSERT INTO customer (First_name, Last_name, Email_address, Phone_number, Create_password) "
                           + "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement insertStmt = connection.prepareStatement(insertQuery)) {
            insertStmt.setString(1, customerModel.getFirstname());
            insertStmt.setString(2, customerModel.getLastname());
            insertStmt.setString(3, customerModel.getEmail());
            insertStmt.setString(4, customerModel.getPhone());
            insertStmt.setString(5, customerModel.getCreate());

            int rowsInserted = insertStmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("User registered successfully.");
                return true;
            } else {
                System.out.println("User registration failed. No rows affected.");
                return false;
            }
        } catch (SQLException e) {
            System.err.println("Error during customer registration: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}
