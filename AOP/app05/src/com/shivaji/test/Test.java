package com.shivaji.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shivaji.beans.Employee;
import com.shivaji.service.EmployeeService;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("/com/shivaji/resources/applicationContext.xml");
		Employee emp = (Employee) context.getBean("empBean");
		EmployeeService empService = (EmployeeService)context.getBean("empService");
		String message="";
		
		try {
			message = empService.createEmployee(emp);
			
		} catch (Exception e) {
			//e.printStackTrace();
		}
		System.out.println(message);
	}

}
