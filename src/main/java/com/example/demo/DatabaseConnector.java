package com.example.demo;

import java.sql.*;
public class DatabaseConnector {
    private String dbURL = "jdbc:mysql://localhost:3306/test";
    private String username = "root";
    private String password = "";
    private Connection connection;

    public DatabaseConnector() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(dbURL, username, password);
            if (connection != null) {
                System.out.println("Success");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveFormData(String name, String regNumber, String password, String gender) {
        try {
            String query = "INSERT INTO labtask (name, regNumber, password, gender) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, regNumber);
            preparedStatement.setString(3, password);
            preparedStatement.setString(4, gender);
            int noOfRowsInserted = preparedStatement.executeUpdate();
            if (noOfRowsInserted > 0) {
                System.out.println(noOfRowsInserted + " rows inserted!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}