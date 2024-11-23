package com.shivaji.beans;

public class Student {
	static {
		System.out.println("Student Bean Class Loading...");
	}
	public Student() {
		System.out.println("Student Bean Class Instantiation...");
	}
	
	private String sid;
	private String sname;
	private String saddr;
	
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		System.out.println("sid property is initialized with "+sid);
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		System.out.println("sname property is initialized with "+sname);
		this.sname = sname;
	}
	public String getSaddr() {
		return saddr;
	}
	public void setSaddr(String saddr) {
		System.out.println("saddr property is initialized with "+saddr);
		this.saddr = saddr;
	}
	public void getStudentDetails() {
		System.out.println("Student Details");
		System.out.println("--------------------");
		System.out.println("Student Id      : "+sid);
		System.out.println("Student Name    : "+sname);
		System.out.println("Student Address : "+saddr);
	}
}
