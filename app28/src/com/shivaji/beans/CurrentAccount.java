package com.shivaji.beans;

public class CurrentAccount implements Account {
	public void createAccount(){
		System.out.println("CurrentAccount Created");
	}
	public void searchAccount() {
		System.out.println("CurrentAccount Identified");
	}
	public void updateAccount() {
		System.out.println("CurrentAccount Updated");
	}
	public void deleteAccount() {
		System.out.println("CurrentAccount Deleted");
	}
}
