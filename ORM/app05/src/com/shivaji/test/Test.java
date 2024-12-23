package com.shivaji.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shivaji.dao.EmployeeDao;
import com.shivaji.entity.Employee;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		EmployeeDao empDao = (EmployeeDao)context.getBean("empDao");
		/*
		Employee emp = new Employee();
		emp.setEno(222);
		emp.setEname("BBB");
		emp.setEsal(3000);
		emp.setEaddr("Goa");
		String status = empDao.insertEmployee(emp);
		System.out.println(status);
		*/
		/*
		Employee emp = empDao.findEmployee(111);
		System.out.println("Employee Details");
		System.out.println("-----------------------------");
		System.out.println("Employee Number   : "+emp.getEno());
		System.out.println("Employee Name     : "+emp.getEname());
		System.out.println("Employee Salary   : "+emp.getEsal());
		System.out.println("Employee Address  : "+emp.getEaddr());
		*/
		/*
		Employee emp = new Employee();
		emp.setEno(111);
		emp.setEname("CCC");
		emp.setEsal(2500);
		emp.setEaddr("Bhopal");
		String status = empDao.updateEmployee(emp);
		System.out.println(status);
		*/
		
		String status = empDao.removeEmployee(111);
		System.out.println(status);
		
	}

}
