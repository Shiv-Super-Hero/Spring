package com.shivaji.test;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shivaji.beans.Account;

public class Test {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("/com/shivaji/resources/applicationContext.xml");
		Account acc = (Account) context.getBean("account");
		acc.createAccount();
		acc.searchAccount();
		acc.updateAccount();
		acc.deleteAccount();
	}

}

// This Program deals with Custom Event Handling Mechanism where all the activities or events are update on the basis of user
// defined event handling mechanism.