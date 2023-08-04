package com.project.quiz.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Quiz {
	
    public List<QuizResult> quizResults = new ArrayList<>();
     public List<String> grades = new ArrayList<>();
     


	

    public void takeQuiz(int studentId, String studentName, Set<Question> questions) {
        int score = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Quiz Started ===");
        System.out.println("Hello " + studentName + "... Answer the following questions:");

        

        for (Question que : questions) {
        	
            System.out.println("\n" + que.getQuestionText());
            System.out.println("1. " + que.getOption1());
            System.out.println("2. " + que.getOption2());
            System.out.println("3. " + que.getOption3());
            System.out.println("4. " + que.getOption4());
            System.out.println("Enter your Answer (1, 2, 3, or 4): ");
            
            int userChoice = sc.nextInt();
            if (userChoice == que.getCorrectOption()) {
                System.out.println("Correct!");
                
                score++;
                
            } else {
                System.out.println("Incorrect!");
            }
        }

        System.out.println("\n=== Quiz Finished ===");
        System.out.println("Your Score: " + score);
        System.out.println("You Got: " + calculateGrade(score) +" Grade");
        
        String grade = calculateGrade(score);
        grades.add(grade);

        // Store quiz results in the database
        storeQuizResult(studentId, studentName, score, grade);

        // now (storing) store quiz results in the database
       
    }
    
    //Not Stored In Database It will Calculate On The BAsis of Score.
    
    private String calculateGrade(int score) {
        if (score >= 8) {
            return "A";
        } else if (score >= 6) {
            return "B";
        } else if (score >= 5) {
            return "C";
        } else if (score >= 4) {
            return "D";
        } else {
            return "F";
        }
    }




    
    private void storeQuizResult(int studentId, String studentName, int score, String grade) {
        try {
            Connection con = JDBCConnection.getConnectionDetails();
           
            //  insert into QuizResult  table
            String insertQuery = "INSERT INTO QuizResult (student_id, student_name, score) VALUES (?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(insertQuery);
            ps.setInt(1, studentId);
            ps.setString(2, studentName);
            ps.setInt(3, score);
            
            

            // execute the INSERT statement
            ps.executeUpdate();

            System.out.println("Yesss...Quiz result stored in the database Successfully!!!!");
            
            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private void fetchQuizResults() {
        try {
            Connection con = JDBCConnection.getConnectionDetails();
            String query = "SELECT * FROM QuizResult";

            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int studentId = rs.getInt("student_id"); // Row
                String studentName = rs.getString("student_name");
                int score = rs.getInt("score");
                
                String grade = calculateGrade(score); //Calculate Grade but Grade not Store In Database
                									// Storing inside this Variable	
                QuizResult quizResult = new QuizResult(studentId, studentName, score, grade);
                quizResults.add(quizResult);
                
                grades.add(grade);
            }

            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
           
        }
    }

    public void displayQuizResult() {
        fetchQuizResults();

        System.out.println("\n=== Quiz Results ===");
        if (quizResults.isEmpty()) {
            System.out.println("No quiz results found.");
        } else {
            for (int i = 0; i < quizResults.size(); i++) {
                QuizResult result = quizResults.get(i);
                String grade = grades.get(i); // Retrieve the grade from the ArrayList
                System.out.println("Student ID: " + result.getStudentId());
                System.out.println("Student Name: " + result.getStudentName());
                System.out.println("Score: " + result.getScore());
                System.out.println("Grade: " + grade); // Display the grade
                System.out.println("-------------------------");
            }
        }
    }

    public Set<Question> getQuizQuestions() {
        Set<Question> quizQuestions = new HashSet<>();
        try {
            Connection con = JDBCConnection.getConnectionDetails();
            String query = "SELECT * FROM QuizQuestions";

            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int questionId = rs.getInt("question_id");
                String questionText = rs.getString("question_text");
                String option1 = rs.getString("option1");
                String option2 = rs.getString("option2");
                String option3 = rs.getString("option3");
                String option4 = rs.getString("option4");
                int correctOption = rs.getInt("correct_option");

                Question question = new Question(questionId, questionText, option1, option2, option3, option4, correctOption);
                quizQuestions.add(question);
            }

            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Invalid Input");
        }
        return quizQuestions;
    }
    private boolean studentResultById(int id) {
		boolean valid = false;
		try {
			Connection con =JDBCConnection.getConnectionDetails();
			String Query ="SELECT * FROM QuizResult WHERE student_id = ?";
 
			PreparedStatement ps = con.prepareStatement(Query);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
	            int studentId = rs.getInt("student_id");
	            String studentName = rs.getString("student_name");
	            int score = rs.getInt("score");

	            String grade = calculateGrade(score);
	            QuizResult quizResult = new QuizResult(studentId, studentName, score, grade);
	            quizResults.add(quizResult);

	            grades.add(grade);
	        }
			rs.close();
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return valid;   	
	
}
	public void displayQuizResult(int id) { 
	
	studentResultById(id);

    System.out.println("\n=== Quiz Results ===");
    if (quizResults.isEmpty()) {
        System.out.println("No quiz results found for student ID: " + id);
    } else {
        for (int i = 0; i < quizResults.size(); i++) {
            QuizResult result = quizResults.get(i);
            String grade = grades.get(i); // Retrieve grade from the ArrayList
            System.out.println("Student ID: " + result.getStudentId());
            System.out.println("Student Name: " + result.getStudentName());
            System.out.println("Score: " + result.getScore());
            System.out.println("Grade: " + grade); // Display the grade
            System.out.println("-------------------------");
        }
    }
}
     }
    

	

