package com.shivaji.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shivaji.beans.Show;
import com.shivaji.service.ShowService;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("/com/shivaji/resources/applicationContext.xml"); 
		Show show = (Show)context.getBean("showBean");
		
		ShowService showService = (ShowService)context.getBean("showService");
		
		try {
			showService.runShow(show);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		
	}

}
