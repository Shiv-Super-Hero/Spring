package com.shivaji.beans;

public class SavingsAccount implements Account{
	public void createAccount(){
		System.out.println("SavingsAccount Created");
	}
	public void searchAccount() {
		System.out.println("SavingsAccount Identified");
	}
	public void updateAccount() {
		System.out.println("SavingsAccount Updated");
	}
	public void deleteAccount() {
		System.out.println("SavingsAccount Deleted");
	}
}
