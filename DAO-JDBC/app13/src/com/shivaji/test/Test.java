package com.shivaji.test;

import java.io.File;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shivaji.dao.EmployeeDao;
import com.shivaji.dto.Employee;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("/com/shivaji/resources/applicationContext.xml");
		EmployeeDao empDao = (EmployeeDao)context.getBean("empDao");
		/*
		Employee emp = new Employee();
		emp.setEno(111);
		emp.setEname("AAA");
		emp.setEmp_Image(new File("C:\\Users\\Shiv Narayan Singh\\OneDrive\\Pictures\\Screenshots\\Shiv_Narayan.png"));
		emp.setEmp_Resume(new File("C:\\Users\\Shiv Narayan Singh\\OneDrive\\Pictures\\Slide Shows\\191210041_Ravi_shah.pdf"));
		
		empDao.insertEmployee(emp);
		System.out.println("Employee Inserted Successfully!");
		*/
		Employee emp = empDao.readEmployee(111);
		System.out.println("Employee Details");
		System.out.println("--------------------");
		System.out.println("Employee Number : "+emp.getEno());
		System.out.println("Employee Name   : "+emp.getEname());
		System.out.println("Employee Image  : "+emp.getEmp_Image().getAbsolutePath());
		System.out.println("Employee Resume : "+emp.getEmp_Resume().getAbsolutePath());
		
	}

}
