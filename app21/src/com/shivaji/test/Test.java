package com.shivaji.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shivaji.beans.Course;
import com.shivaji.beans.Student;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("/com/shivaji/resources/applicationContext.xml");
		
		Course course = (Course)context.getBean("courseBean");
		
		Student std = (Student)context.getBean("studentBean");
		std.getStudentDetails();
	}

}

// By using this C-namespace property we can reduce the use of constructor-arg tag in our xml file and the issue
// with the mapping order is reduced to a great extent. If we want to execute both constructor-arg and inline C-namespace
// then ambiguity will result as exception.