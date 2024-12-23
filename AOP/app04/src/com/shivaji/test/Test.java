package com.shivaji.test;

import org.springframework.context.ApplicationContext; 
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shivaji.beans.Account;
import com.shivaji.beans.Cheque;
import com.shivaji.service.TransactionService;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("/com/shivaji/resources/applicationContext.xml");
		Account acc = (Account) context.getBean("accBean");
		Cheque cheque = (Cheque) context.getBean("chequeBean");
		
		TransactionService tx_Service = (TransactionService)context.getBean("proxy");
		tx_Service.debit(acc, cheque);
	}

}
