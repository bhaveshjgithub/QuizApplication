package com.project.quiz.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTable {
    public void createTables() {
    	createNewSchema();
        createStudentInfoTable();
        createQuizQuestionsTable();
        createQuizResultTable();
    
    }
    
    public void createNewSchema() {
        try {
            // Load the Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "root");

            // Create a new schema
            Statement stmt = con.createStatement();
            String createSchemaSQL = "CREATE SCHEMA IF NOT EXISTS quiz";
            stmt.executeUpdate(createSchemaSQL);

            stmt.close();
            con.close();

            System.out.println("Schema creation Done successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createStudentInfoTable() {
        try {
            // Load driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // connection to the database
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz", "root", "root");

            /// Hare create the StudentInfo table
            String createTableQuery = "CREATE TABLE IF NOT EXISTS StudentRegistration ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY,"
                    + "firstname VARCHAR(50) NOT NULL,"
                    + "lastname VARCHAR(50) NOT NULL,"
                    + "address VARCHAR(100),"
                    + "mobilenumber INT,"
                    + "username VARCHAR(100),"
                    + "password VARCHAR(100),"
                    + "city VARCHAR(50)"
                    + ")";

            
            
            Statement statement = con.createStatement();

            
            statement.execute(createTableQuery);

            System.out.println("Table 'StudentRegistration' created successfully");

            
            statement.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createQuizQuestionsTable() {
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz", "root", "root");

            // Now  create the QuizQuestions table
            String createTableQuery = "CREATE TABLE IF NOT EXISTS QuizQuestions ("
                    + "question_id INT AUTO_INCREMENT PRIMARY KEY,"
                    + "question_text VARCHAR(500) NOT NULL,"
                    + "option1 VARCHAR(200) NOT NULL,"
                    + "option2 VARCHAR(200) NOT NULL,"
                    + "option3 VARCHAR(200) NOT NULL,"
                    + "option4 VARCHAR(200) NOT NULL,"
                    + "correct_option INT"
                    + ")";

            
            Statement statement = con.createStatement();

            
            statement.execute(createTableQuery);

            System.out.println("Table 'QuizQuestions' created successfully");

            statement.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void createQuizResultTable() {
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz", "root", "root");

            // Hare we create the QuizResult table
            String createTableQuery = "CREATE TABLE IF NOT EXISTS QuizResult ("
                    + "result_id INT AUTO_INCREMENT PRIMARY KEY,"
                    + "student_id INT,"
                    + "student_name VARCHAR(50),"
                    + "score INT,"
                    + "FOREIGN KEY (student_id) REFERENCES StudentRegistration(id)"
                    + ")";   
            // Little Correction hare If Foreign Key That Is studentId is duplicated... So Excution will NOt POsssible 

            
            Statement statement = con.createStatement();

          
            statement.execute(createTableQuery);

            System.out.println("Table of 'QuizResult' created successfully");

            statement.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}

