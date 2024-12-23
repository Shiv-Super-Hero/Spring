package com.shivaji.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shivaji.beans.Employee;
import com.shivaji.dao.EmployeeDao;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("/com/shivaji/resources/applicationContext.xml");
		EmployeeDao empDao = (EmployeeDao)context.getBean("empDao");
		/*
		Employee emp = new Employee();
		emp.setEno(222);
		emp.setEname("BBB");
		emp.setEsal(3000);
		emp.setEaddr("Goa");
		
		String status = empDao.insert(emp);
		System.out.println(status);
		*/
		/*
		Employee emp = empDao.search(111);
		if(emp == null)
			System.out.println("Employee Not existed");
		else {
			System.out.println("Employee Details"); 
			System.out.println("----------------------");
			System.out.println("Employee Number   : "+emp.getEno());
			System.out.println("Employee Name     : "+emp.getEname());
			System.out.println("Employee Salary   : "+emp.getEsal());
			System.out.println("Employee Address  : "+emp.getEaddr());
		}
		*/
		
		Employee emp = new Employee();
		emp.setEno(222);
		//emp.setEname("ZZZ");
		//emp.setEsal(5000);
		//emp.setEaddr("Kullu");
		String status = empDao.delete(emp);
		System.out.println(status);
	}

}
