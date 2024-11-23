package com.shivaji.test;

import java.util.List;

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
		emp.setEsal(5000);
		emp.setEaddr("Goa");
		String status = empDao.add(emp);
		System.out.println(status);
		*/
		/*
		Employee emp = empDao.search(111);
		if(emp == null) {
			System.out.println("Employee Not Existed");
		}else {
			System.out.println("Employee Details");
			System.out.println("---------------------");
			System.out.println("Employee Number   : "+emp.getEno());
			System.out.println("Employee Name     : "+emp.getEname());
			System.out.println("Employee Salary   : "+emp.getEsal());
			System.out.println("Employee Address  : "+emp.getEaddr());
		*/
		/*
		List<Employee> empList = empDao.getAllEmployees();
		System.out.println("ENO\tENAME\tESAL\tEADDR");
		System.out.println("-------------------------");
		for(Employee emp : empList) {
			System.out.print(emp.getEno()+"\t");
			System.out.print(emp.getEname()+"\t");
			System.out.print(emp.getEsal()+"\t");
			System.out.print(emp.getEaddr()+"\n");
		*/
		/*
		Employee emp = new Employee();
		emp.setEno(666);
		emp.setEname("XXX");
		emp.setEsal(7500);
		emp.setEaddr("Kota");
		String status = empDao.update(emp);
		System.out.println(status);
		*/
		
		String status = empDao.delete(666);
		System.out.println(status);
		}
		
		

}
