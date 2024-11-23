package com.shivaji.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;

public class Employee {
	private String eid;
	private String ename;
	private float esal;
	private String eaddr;
	private Account acc;
	/*
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public float getEsal() {
		return esal;
	}
	public void setEsal(float esal) {
		this.esal = esal;
	}
	public String getEaddr() {
		return eaddr;
	}
	public void setEaddr(String eaddr) {
		this.eaddr = eaddr;
	}
	public Account getAcc() {
		return acc;
	}
	
	public void setAcc(Account acc) {
		this.acc = acc;
	}
	*/
	
	    //@Required
		@Autowired(required=true)
		
	public Employee(String eid,String ename,float esal,String eaddr, @Qualifier("currentAcc") Account acc) {
		this.eid = eid;
		this.ename = ename;
		this.esal = esal;
		this.eaddr = eaddr;
		this.acc = acc;
	}
	public void getEmployeeDetails() {
		System.out.println("Employee Details");
		System.out.println("------------------------");
		System.out.println("Employee Id      : "+eid);
		System.out.println("Employee Name    : "+ename);
		System.out.println("Employee Salary  : "+esal);
		System.out.println("Employee Address : "+eaddr);
		System.out.println();
		System.out.println("Account Details");
		System.out.println("------------------------");
		System.out.println("Account Number   : "+acc.getAccNo());
		System.out.println("Account Name     : "+acc.getAccName());
		System.out.println("Account Type     : "+acc.getAccType());
		System.out.println("Account Balance  : "+acc.getBalance());
	}
}
