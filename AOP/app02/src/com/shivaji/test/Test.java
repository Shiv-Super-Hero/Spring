package com.shivaji.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shivaji.beans.Student;
import com.shivaji.service.InstituteService;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("/com/shivaji/resources/applicationContext.xml");
		InstituteService inst_Service = (InstituteService)context.getBean("proxy");
		Student std = (Student)context.getBean("student");
		
		inst_Service.enquiry(std, "JAVA");
		System.err.println();
		inst_Service.registration(std, "JAVA");
		
	}

}
