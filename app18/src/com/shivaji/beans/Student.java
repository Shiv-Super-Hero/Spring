package com.shivaji.beans;

public class Student {
	Branch branch;
	/*
	public Student(Branch branch) {
		this.branch=branch;
	}
	*/
	
	public Branch getBranch() {
		return branch;
	}
	
	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	
	public String getStudentName() {
		return "Shivaji";
	}
}
