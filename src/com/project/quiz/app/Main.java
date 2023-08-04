package com.project.quiz.app;

import java.util.Scanner;

public class Main {
   
    public static void main(String[] args) {
    
        Scanner scanner = new Scanner(System.in);
        
        CreateTable table = new CreateTable();
        table.createTables();
       

        while (true) {
        	
            System.out.println("=== Quiz Application ===");
            System.out.println("1. Admin");
            System.out.println("2. Student");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
      
            int choice = scanner.nextInt();
            
           switch (choice) {
                case 1:
                    Admin admin = new Admin();
                    admin.adminMenu();
                    break;
                case 2:
                    //Student student = new Student();
                    //student.studentMenu();
                    break;
                case 3:
                    System.out.println("Exiting the application. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
