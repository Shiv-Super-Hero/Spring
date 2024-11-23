package com.shivaji.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shivaji.beans.Account;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("/com/shivaji/resources/applicationContext.xml");
		Account acc = (Account) context.getBean("accBean");
		acc.getAccountDetails();
	}

}
// This PostProcessor concept is awesome if anyone forgets to write the country code and Bank Account types and many more.