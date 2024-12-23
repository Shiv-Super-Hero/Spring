package com.shivaji.beans;

import com.shivaji.publisher.AccountEventPublisher;

public class Account {
	private AccountEventPublisher publisher;
	
	public void setPublisher(AccountEventPublisher publisher) {
		this.publisher = publisher;
	}
	
	public void createAccount() {
		System.out.println("*******Account Created*******");
		publisher.publish("Account Created");
	}
	public void searchAccount() {
		System.out.println("*******Account Identified*******");
		publisher.publish("Account Identified");
	}
	public void updateAccount() {
		System.out.println("*******Account Updated********");
		publisher.publish("Account Updated");
	}
	public void deleteAccount() {
		System.out.println("*******Account Deleted********");
		publisher.publish("Account Deleted");
	}
}
