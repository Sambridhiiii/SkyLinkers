package com.Skylinker.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DbConfig is a configuration class for managing database connections.
 * It handles the connection to a MySQL database using JDBC.
 * 
 * LMU ID: 23048681  
 * NAME: Sambridhi Shrestha
 */
public class DbConfig {

    // Database configuration information
    private static final String DB_NAME = "skylinker";
    private static final String URL = "jdbc:mysql://localhost:3306/" + DB_NAME + "?useSSL=false&serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    /**
     * Establishes a connection to the database.
     * Loads the MySQL JDBC driver and connects using the configured URL and credentials.
     *
     * @return Connection object representing the database connection
     * @throws SQLException           if a database access error occurs or the URL is invalid
     * @throws ClassNotFoundException if the MySQL JDBC driver class is not found
     */
    public static Connection getDbConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
