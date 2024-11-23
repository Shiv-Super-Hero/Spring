package com.shivaji;

public class Employee {
	String eid;
	String ename;
	float esal;
	String eaddr;
	
	public Employee(String eid,String ename,float esal,String eaddr) {
		this.eid = eid;
		this.ename = ename;
		this.esal = esal;
		this.eaddr = eaddr;
	}
	public void getEmpDetails() {
		System.out.println("Employee Details");
		System.out.println("-------------------");
		System.out.println("Employee Id      : "+eid);
		System.out.println("Employee Name    : "+ename);
		System.out.println("Employee Salary  : "+esal);
		System.out.println("Employee Address : "+eaddr);
		
	}
}
