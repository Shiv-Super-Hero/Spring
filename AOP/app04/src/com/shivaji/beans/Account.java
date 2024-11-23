package com.shivaji.beans;

public class Account {
	private String accNo;
	private String accHolderName;
	private String accType;
	private int balance;
	
	public String getAccNo() {
		return accNo;
	}
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}
	public String getAccHolderName() {
		return accHolderName;
	}
	public void setAccHolderName(String accHolderName) {
		this.accHolderName = accHolderName;
	}
	public String getAccType() {
		return accType;
	}
	public void setAccType(String accType) {
		this.accType = accType;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public void getAccDetails() {
		System.out.println("Account Details");
		System.out.println("--------------------");
		System.out.println("Account Number      : "+accNo);
		System.out.println("Account Holder Name : "+accHolderName);
		System.out.println("Account Type        : "+accType);
		System.out.println("Account Balance     : "+balance);
	}
}
