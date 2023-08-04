package com.project.quiz.app;

public class QuizResult {
    private int studentId;
    private String studentName;
    private double score;
    private String grade;
	public QuizResult(int studentId, String studentName, double score, String grade) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.score = score;
		this.grade = grade;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
    
	

}
