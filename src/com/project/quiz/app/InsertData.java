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
    
    
     // If This Questions Is AVailable Then It will not Add.
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
            
            PreparedStatement ps3 = con.prepareStatement(Query);

            ps3.setString(1, "Which Java access modifier provides the highest level of visibility?");
            ps3.setString(2, "private");
            ps3.setString(3, "default");
            ps3.setString(4, "protected");
            ps3.setString(5, "public");
            ps3.setInt(6, 4);

            ps3.executeUpdate();
            ps3.close();

            
            PreparedStatement ps4 = con.prepareStatement(Query);

            ps4.setString(1, "What is the purpose of the 'this' keyword in Java?");
            ps4.setString(2, "Refer to the current instance of the class");
            ps4.setString(3, "Declare a new object");
            ps4.setString(4, "Access superclass members");
            ps4.setString(5, "Terminate program execution");
            ps4.setInt(6, 1);

            ps4.executeUpdate();
            ps4.close();

            
            PreparedStatement ps5 = con.prepareStatement(Query);

            ps5.setString(1, "Which loop construct is used to iterate a specific number of times?");
            ps5.setString(2, "for");
            ps5.setString(3, "while");
            ps5.setString(4, "do-while");
            ps5.setString(5, "foreach");
            ps5.setInt(6, 1);

            ps5.executeUpdate();
            ps5.close();

            
            PreparedStatement ps6 = con.prepareStatement(Query);

            ps6.setString(1, "In Java, which data type is used to store floating-point numbers with double precision?");
            ps6.setString(2, "float");
            ps6.setString(3, "double");
            ps6.setString(4, "decimal");
            ps6.setString(5, "real");
            ps6.setInt(6, 2);

            ps6.executeUpdate();
            ps6.close();


            PreparedStatement ps7 = con.prepareStatement(Query);

            ps7.setString(1, "What is the Java keyword used to create an instance of a class?");
            ps7.setString(2, "create");
            ps7.setString(3, "new");
            ps7.setString(4, "instance");
            ps7.setString(5, "alloc");
            ps7.setInt(6, 2);

            ps7.executeUpdate();
            ps7.close();

            
            PreparedStatement ps8 = con.prepareStatement(Query);

            ps8.setString(1, "Which Java data type is used to represent a single 16-bit Unicode character?");
            ps8.setString(2, "char");
            ps8.setString(3, "byte");
            ps8.setString(4, "string");
            ps8.setString(5, "int");
            ps8.setInt(6, 1);

            ps8.executeUpdate();
            ps8.close();

            
            PreparedStatement ps9 = con.prepareStatement(Query);

            ps9.setString(1, "What is the process of converting an object into a byte stream called in Java?");
            ps9.setString(2, "Serialization");
            ps9.setString(3, "Conversion");
            ps9.setString(4, "Casting");
            ps9.setString(5, "Parsing");
            ps9.setInt(6, 1);

            ps9.executeUpdate();
            ps9.close();

            
            PreparedStatement ps10 = con.prepareStatement(Query);

            ps10.setString(1, "Which Java operator is used to compare two values for equality?");
            ps10.setString(2, "==");
            ps10.setString(3, "!=");
            ps10.setString(4, "<=");
            ps10.setString(5, "=>");
            ps10.setInt(6, 1);
            
            
            ps10.executeUpdate();
            ps10.close();
            

            System.out.println("Demo questions also inserted successfully!");

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println();
        }
    }

    
}
