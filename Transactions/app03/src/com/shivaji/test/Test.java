package com.shivaji.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shivaji.dao.TransactionDao;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("/com/shivaji/resources/applicationContext.xml");
		TransactionDao txDao = (TransactionDao)context.getBean("transactionDao");
		/*
		String status = txDao.transferFunds("abc123", "xyz123", 5000);
		System.out.println(status);
		*/
		/*
		String status = txDao.deposit("abc123", 5000);
		System.out.println(status);
		*/
		
		String status = txDao.withDraw("abc123", 1000);
		System.out.println(status);
		
		
	}

}