package com.shivaji.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shivaji.beans.Employee;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("/com/shivaji/resources/applicationContext.xml");
		Employee emp = (Employee) context.getBean("empBean");
		emp.getEmpDetails();
	}

}
// This is an example of Setter method Dependency Injection only through Setter method.
// Previous program was an example of Constructor Dependency Injection.