package com.shivaji.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shivaji.beans.Branch;
import com.shivaji.beans.Student;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("/com/shivaji/resources/applicationContext.xml");
		
		Student student = (Student)context.getBean("student");
		System.out.println(student.getStudentName());
		
		Branch branch = (Branch)context.getBean("branch");
		System.out.println(branch.getBranchName());
	}
}
// This Program deals with the Circular Dependency.
// Circular DI(Dependency Injection) is not supported by Constructor injection bcoz Deadlock like situation occurs.
// Deadlock occurs only in Constructor Injection at the time of bean object creation but in Setter Injection setter methods
// are called after the bean object has successfully created.