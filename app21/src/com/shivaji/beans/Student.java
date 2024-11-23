package com.shivaji.beans;

public class Student {
	private String sid;
	private String sname;
	private String saddr;
	private Course course;
	
	public Student(String sid, String sname, String saddr,Course course) {
		this.sid=sid;
		this.sname=sname;
		this.saddr=saddr;
		this.course=course;
	}
	
	public void getStudentDetails() {
		System.out.println("Student Details");
		System.out.println("--------------------");
		System.out.println("Student Id      : "+sid);
		System.out.println("Student Name    : "+sname);
		System.out.println("Student Address : "+saddr);
		System.out.println();
		System.out.println("Course Details");
		System.out.println("-----------------------");
		System.out.println("Course Id   : "+course.getCid());
		System.out.println("Course Name : "+course.getCname());
		System.out.println("Course Cost : "+course.getCcost());
	}
}
