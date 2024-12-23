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
		Employee emp1 = new Employee();
		emp1.setEno(111);
		emp1.setEname("AAA");
		emp1.setEsal(2500);
		emp1.setEaddr("Hyd");
		empDao.create(emp1);
		System.out.println("Employee "+emp1.getEno()+" Inserted Successfully");
		
		Employee emp2 = new Employee();
		emp2.setEno(666);
		emp2.setEname("FFF");
		emp2.setEsal(4500);
		emp2.setEaddr("Noida");
		empDao.create(emp2);
		System.out.println("Employee "+emp2.getEno()+" Inserted Successfully");
		
		Employee emp3 = new Employee();
		emp3.setEno(777);
		emp3.setEname("GGG");
		emp3.setEsal(5000);
		emp3.setEaddr("Katti");
		empDao.create(emp3);
		System.out.println("Employee "+emp3.getEno()+" Inserted Successfully");
		*/
		/*
		System.out.println("111 Salary   : "+empDao.getEmpSal(111));
		System.out.println("222 Salary   : "+empDao.getEmpSal(555));
		System.out.println("333 Salary   : "+empDao.getEmpSal(777));
		*/
		/*
		Employee emp = empDao.getEmployee(777);
		System.out.println("Employee Details");
		System.out.println("---------------------");
		System.out.println("Employee Number    : "+emp.getEno());
		System.out.println("Employee Name      : "+emp.getEname());
		System.out.println("Employee Salary    : "+emp.getEsal());
		System.out.println("Employee Address   : "+emp.getEaddr());
		*/
		
		List<Employee> emps = empDao.getAllEmployees();
		System.out.println("ENO\tENAME\tESAL\tEADDR");
		System.out.println("------------------------");
		for(Employee emp : emps) {
			System.out.print(emp.getEno()+"\t");
			System.out.print(emp.getEname()+"\t");
			System.out.print(emp.getEsal()+"\t");
			System.out.print(emp.getEaddr()+"\n");
		}
		
		/*
		Employee emp = new Employee();
		emp.setEno(333);
		emp.setEname("XXX");
		emp.setEsal(3200);
		emp.setEaddr("Rajgir");
		empDao.updateEmployee(emp);
		System.out.println("Employee 333 Updated Successfully");
		*/
		/*
		empDao.deleteEmployee(333);
		System.out.println("Employee 333 deleted Successfully!");
		*/
	}

}
