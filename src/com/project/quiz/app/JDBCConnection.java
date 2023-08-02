package com.project.quiz.app;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConnection {
    public static Connection getConnectionDetails() {
        Connection con = null;
        try {
            // Load the Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // establish the connection
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz", "root", "root");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
    
}
