package com.project.quiz.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertData {
    public void insertStudentData(String fname, String lname, String add, int mobileno, String user, String pass, String city) {
        try {
            Connection con = JDBCConnection.getConnectionDetails();
            String query = "INSERT INTO StudentRegistration (firstname, lastname, address, mobilenumber, username, password, city) VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, fname);
            ps.setString(2, lname);
            ps.setString(3, add);
            ps.setLong(4, mobileno);
            ps.setString(5, user);
            ps.setString(6, pass);
            ps.setString(7, city);
           

            int i = ps.executeUpdate();
            System.out.println("Student data inserted successfully!");
            System.out.println(fname +"'s Id is : " + user);

            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void execute(int input) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < input; i++) {
            System.out.println("Enter First Name : ");
            String fname = sc.next();
            System.out.println("Enter Last Name : ");
            String lname = sc.next();
            System.out.println("Enter Address : ");
            String add = sc.next();
            System.out.println("Enter Mobile No. : ");
            int mobileno = sc.nextInt();
            System.out.println("Enter UserId : ");
            String user = sc.next();
            System.out.println("Enter Password : ");
            String pass = sc.next();
            System.out.println("Enter City : ");
            String city = sc.next();
            this.insertStudentData(fname, lname, add, mobileno, user, pass, city);
        }
    }
    
    public void insertQuizQuestion(String question, String option1, String option2, String option3, String option4, int correctOption) {
        try {
        	
            Connection con = JDBCConnection.getConnectionDetails();
            
            String query = "INSERT INTO QuizQuestions (question_text, option1, option2, option3, option4, correct_option) VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, question);
            
            ps.setString(2, option1);
            ps.setString(3, option2);
            ps.setString(4, option3);
            ps.setString(5, option4);
            
            ps.setInt(6, correctOption);

            int i = ps.executeUpdate();
            System.out.println("Quiz question inserted successfully!!!");

            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   

    public void executeQuizQuestionCreation() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Question: ");
        String question = sc.nextLine();
        System.out.println("Enter Option 1: ");
        String option1 = sc.nextLine();
        System.out.println("Enter Option 2: ");
        String option2 = sc.nextLine();
        System.out.println("Enter Option 3: ");
        String option3 = sc.nextLine();
        System.out.println("Enter Option 4: ");
        String option4 = sc.nextLine();
        System.out.println("Enter Correct Option (1, 2, 3, or 4): ");
        int correctOption = sc.nextInt();

        this.insertQuizQuestion(question, option1, option2, option3, option4, correctOption);
    }
    
    
    
    public void availableQuizQuestions() {
        try {
        	
            Connection con = JDBCConnection.getConnectionDetails();

            // Insert pre quiz questions with IGNORE keyword For No Pepitation of Questions.
            String Query = "INSERT IGNORE INTO QuizQuestions (question_text, option1, option2, option3, option4, correct_option)" +
                    " VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement ps1 = con.prepareStatement(Query);

            ps1.setString(1, "Which of the following is not a Java feature?");
            ps1.setString(2, "Dynamic");
            ps1.setString(3, "Architecture Neutral");
            ps1.setString(4, "Use of pointers");
            ps1.setString(5, "Object-oriented");
            ps1.setInt(6, 3);
            
            ps1.executeUpdate();
            ps1.close();

            PreparedStatement ps2 = con.prepareStatement(Query);
            
            
            ps2.setString(1, "What is the return type of the hashCode() method in the Object class?");
            ps2.setString(2, "Object");
            ps2.setString(3, "Int");
            ps2.setString(4, "long");
            ps2.setString(5, "Void");
            
            
            ps2.setInt(6, 2);
            
            ps2.executeUpdate();
            ps2.close();

            System.out.println("Demo questions also inserted successfully!");

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println();
        }
    }

    
}
