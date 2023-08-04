package com.project.quiz.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.util.Set;

public class Student {
    public void studentMenu() {
        Scanner scanner = new Scanner(System.in);
        

        System.out.println("=== Student Menu ===");
        System.out.println("1. Register Students");
        System.out.println("2. Start Quiz");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                registerStudents();
                break;
            case 2:
                startQuiz();
                //studentResultById(id);
                break;
            default:
                System.out.println("Invalid choice. Returning to the main menu.");
                break;
        }
    }

    private void registerStudents() {
    	Scanner scanner = new Scanner(System.in);
        System.out.println("=== Regist er Students ===");
        InsertData insertData = new InsertData();
        insertData.execute(1);
        System.out.println("Registration is completed successfully!! ");
        System.out.println("Now you are  eligible for Quiz");
        
    }

    private void startQuiz() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your student ID: ");
        int studentId = scanner.nextInt();
        scanner.nextLine(); 

        System.out.println("Enter your name: ");
        String studentName = scanner.nextLine();
        

        System.out.println("Enter your user ID: ");
        String userName = scanner.next();
        
        
        System.out.println("Enter your Password: ");
        String password = scanner.next();
       
        
        if (!validStudentId(userName, password)) {
            System.out.println("Invalid student ID. You are Not Registered Student.");
            return;
        }else {
        
        

        // Fetch quiz questions from the database
        Quiz quiz = new Quiz();
        Set<Question> questions = quiz.getQuizQuestions();

        // Start the quiz
        quiz.takeQuiz(studentId, studentName, questions);
    }
        }

    private boolean validStudentId(String userName, String password) {
        boolean Valid = false;
        try {
            Connection con = JDBCConnection.getConnectionDetails();
            String query = "SELECT * FROM StudentRegistration WHERE username = ? AND password = ?";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, userName);
            ps.setString(2, password);
            

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
               Valid = true; // if StudentId Exist In database
            }
         System.out.println("You Entered \nUsername Is: "+userName+"\n Password Is :" + password );
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Valid;
    }
    
    	


	}

   



