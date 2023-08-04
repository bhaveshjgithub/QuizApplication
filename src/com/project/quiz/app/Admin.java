// Admin.java
package com.project.quiz.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Admin {
    public void adminMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("If You Are Praveen Sir Then Enter: \nID = admin  \nPass = admin123");
        System.out.println("\n=== Admin Credentials ===");
        System.out.println("Enter Admin ID: ");
        String adminId = scanner.nextLine();

        System.out.println("Enter Admin Password: "); 
        String adminPassword = scanner.nextLine();

        boolean rightAdmin = adminId.equals("admin") && adminPassword.equals("admin123");

        if (rightAdmin) {
            System.out.println("Admin login successful.");
        
            displayAdminOptionsMenu();
            
        } else {
            System.out.println("Invalid admin credentials. Access denied.");
        }
    }

    private void displayAdminOptionsMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
        	
            System.out.println("=== Admin Menu ===");
            System.out.println("1. Register Students");
            System.out.println("2. Create Quiz Questions");
            System.out.println("3. Insert Demo Question");
            System.out.println("4. Display Quiz Results");
            System.out.println("5. Display Result By StudentId");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    registerStudents();
                    break;
                case 2:
                    createQuizQuestions();
                    
                    break;
                case 3: 
                	InsertData insetdata = new InsertData();
                    insetdata.availableQuizQuestions();
                    
                    break;
                case 4:
                    displayQuizResults();
                    
                    break;
                case 5:
                	displayQuizResultsID();
                	break;
                case 6:
                    System.out.println("Returning to the main menu.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private void registerStudents() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Register Students ===");
        System.out.print("Enter the number of students: ");
        int numOfStudents = scanner.nextInt();
        scanner.nextLine();

        InsertData insertData = new InsertData();
        insertData.execute(numOfStudents);

        System.out.println("Registration completed successfully!");
    }

    private void createQuizQuestions() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Create Quiz Questions ===");

        InsertData insertData = new InsertData();
        insertData.executeQuizQuestionCreation();
        //////insertData.insertPredefinedQuizQuestions();

        System.out.println("Quiz questions created successfully!");
    }

    private void displayQuizResults() {
        Quiz quiz = new Quiz();
        quiz.displayQuizResult();
    }
    
    private void displayQuizResultsID() {
       Scanner scanner = new Scanner(System.in);
       System.out.println("=== Quiz Result By ID ===");
       System.out.println("Enter Student ID: ");
       
       int studentId = scanner.nextInt();

    	Quiz quiz = new Quiz();
       
        quiz.displayQuizResult(studentId);
    }
   

    
}
