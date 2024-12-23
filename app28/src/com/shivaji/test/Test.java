package com.shivaji.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shivaji.beans.CurrentAccount;
import com.shivaji.beans.SavingsAccount;
import com.shivaji.factory.AccountFactory;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("/com/shivaji/resources/applicationContext.xml");
		
		AccountFactory savingsAccFactory = (AccountFactory)context.getBean("savingsAccountFactory");
		SavingsAccount savingsAccount = (SavingsAccount)savingsAccFactory.getAccount();
		savingsAccount.createAccount();
		savingsAccount.searchAccount();
		savingsAccount.updateAccount();
		savingsAccount.deleteAccount();
		System.out.println();
		AccountFactory currentAccFactory = (AccountFactory)context.getBean("currentAccountFactory");
		CurrentAccount currentAccount = (CurrentAccount)currentAccFactory.getAccount();
		currentAccount.createAccount();
		currentAccount.searchAccount();
		currentAccount.updateAccount();
		currentAccount.deleteAccount();
	}

}

// Here we are not explicitly creating any method [getAccount()] IOC Container is creating the getAccount() method. Here
// AccountFactory is an abstract class and its method getAccount() is also abstract. Its implementation is entirely provided
// by IOC Container.