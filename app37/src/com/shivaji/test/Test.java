package com.shivaji.test;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.shivaji.beans.DBBean;

public class Test {

	public static void main(String[] args) {
		System.setProperty("spring.profiles.active", "production");
		GenericXmlApplicationContext context = new GenericXmlApplicationContext();
		context.load("/com/shivaji/resources/applicationContext-development.xml","/com/shivaji/resources/applicationContext-production.xml");
		context.refresh();
		DBBean db = (DBBean)context.getBean("dbBean");
		db.displayDBDetails();
	}
}
