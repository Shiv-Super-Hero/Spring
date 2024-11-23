package com.shivaji.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shivaji.beans.Student;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("/com/shivaji/resources/applicationContext.xml");
		Student student = (Student)context.getBean("studentBean");
		student.getStudentDetails();
	}

}
// First Constructor sets the values to the attributes then setter methods come into picture which overrides values of
// each and every attributes. In the race between Setter method DI and Constructor DI definitely Constructor will win
// but the attributes contains the values assigned to it at last that is why the o/p is of Setter method DI.