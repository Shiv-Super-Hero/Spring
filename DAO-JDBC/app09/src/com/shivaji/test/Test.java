package com.shivaji.test;

import java.util.ArrayList;
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
		Employee e1 = new Employee();
		e1.setEno(111);
		e1.setEname("AAA");
		e1.setEsal(2000);
		e1.setEaddr("Hyd");
		
		Employee e2 = new Employee();
		e2.setEno(222);
		e2.setEname("BBB");
		e2.setEsal(2500);
		e2.setEaddr("Goa");
		
		Employee e3 = new Employee();
		e3.setEno(333);
		e3.setEname("CCC");
		e3.setEsal(3000);
		e3.setEaddr("Manali");
		
		Employee e4 = new Employee();
		e4.setEno(444);
		e4.setEname("DDD");
		e4.setEsal(3500);
		e4.setEaddr("Delhi");
		
		List<Employee> empList = new ArrayList<Employee>();
		empList.add(e1);
		empList.add(e2);
		empList.add(e3);
		empList.add(e4);
		
		int[] rowCounts = empDao.insert(empList);
		for(int rowCount : rowCounts) {
			System.out.println("Row Count  : "+rowCount);
		}
		*/
		int[] rowCounts = empDao.update();
		for(int rowCount : rowCounts) {
			System.out.println("Row Count  : "+rowCount);
		}
	}

}
