package com.shivaji.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shivaji.beans.Account;
import com.shivaji.exception.InSufficientFundsException;
import com.shivaji.service.TransactionService;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("/com/shivaji/resources/applicationContext.xml");
		Account acc = (Account)context.getBean("accBean");
		TransactionService tx_Service = (TransactionService)context.getBean("transaction");
		
		try {
			tx_Service.withdraw(acc, 10000);
		} catch (InSufficientFundsException e) {
				e.printStackTrace();
		}
		
	}

}
