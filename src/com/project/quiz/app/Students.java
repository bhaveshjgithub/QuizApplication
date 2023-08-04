package com.project.quiz.app;

public class Students {
	private String studentName;
	private String studentLastname;
	private String studentScore;
	private String grade;
	public Students(String studentName, String studentLastname, String studentScore, String grade) {
		super();
		this.studentName = studentName;
		this.studentLastname = studentLastname;
		this.studentScore = studentScore;
		this.grade = grade;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentLastname() {
		return studentLastname;
	}
	public void setStudentLastname(String studentLastname) {
		this.studentLastname = studentLastname;
	}
	public String getStudentScore() {
		return studentScore;
	}
	public void setStudentScore(String studentScore) {
		this.studentScore = studentScore;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}

}
