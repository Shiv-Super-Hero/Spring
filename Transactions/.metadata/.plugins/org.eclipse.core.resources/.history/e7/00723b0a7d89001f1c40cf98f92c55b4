package com.shivaji.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shivaji.dao.TransactionDao;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("/com/shivaji/resources/applicationContext.xml");
		TransactionDao txDao = (TransactionDao)context.getBean("transactionDao");
		String status = txDao.transferFunds("abc123", "aaa123", 5000);
		System.out.println(status);
	}

}
