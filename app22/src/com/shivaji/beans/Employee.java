package com.shivaji.beans;

public class Employee {
	private String eid;
	private String ename;
	private float esal;
	private Account acc;
	private Address addr;
	
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
	public Account getAcc() {
		return acc;
	}
	public void setAcc(Account acc) {
		this.acc = acc;
	}
	public Address getAddr() {
		return addr;
	}
	public void setAddr(Address addr) {
		this.addr = addr;
	}
	*/
	
	public Employee(String eid,String ename,float esal,Account acc,Address addr) {
		this.eid=eid;
		this.ename=ename;
		this.esal=esal;
		this.acc=acc;
		this.addr=addr;
	}
	
	
	public void getEmpDetails() {
		System.out.println("Employee Details");
		System.out.println("------------------------");
		System.out.println("Employee Id     : "+eid);
		System.out.println("Employee Name   : "+ename);
		System.out.println("Employee Salary : "+esal);
		System.out.println();
		System.out.println("Employee Account Details");
		System.out.println("-------------------------");
		System.out.println("Account Number  : "+acc.getAccNo());
		System.out.println("Account Name    : "+acc.getAccName());
		System.out.println("Account Type    : "+acc.getAccType());
		System.out.println("Account Balance : "+acc.getBalance());
		System.out.println();
		System.out.println("Address Details");
		System.out.println("------------------------");
		System.out.println("House Number    : "+addr.getHno());
		System.out.println("Street Name     : "+addr.getStreet());
		System.out.println("City Name       : "+addr.getCity());
		System.out.println("State Name      : "+addr.getState());
	}
}
