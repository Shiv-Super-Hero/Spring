package com.shivaji.beans;

public class Branch {
	Student student;
	/*
	public Branch(Student student) {
		this.student = student;
	}
	*/
	public Student getStudent() {
		return student;
	}
	
	public void setStudent(Student student) {
		this.student = student;
	}
	
	public String getBranchName() {
		return "Computers";
	}
}
