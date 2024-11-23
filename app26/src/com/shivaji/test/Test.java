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

// If we apply both explicit wiring and Autowiring then explicit wiring will dominate and we get the results corresponding to 
// explicit wiring.For more details study 'applicationContext.xml' file.
