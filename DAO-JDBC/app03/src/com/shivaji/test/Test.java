package com.shivaji.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shivaji.dao.EmployeeDao;
import com.shivaji.dto.Employee;

public class Test {

	public static void main(String[] args)throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("/com/shivaji/resources/applicationContext.xml");
		EmployeeDao employeeDao = (EmployeeDao)context.getBean("employeeDao");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println();
			System.out.println("1. Add Employee");
			System.out.println("2. Search Employee");
			System.out.println("3. Update Employee");
			System.out.println("4. Delete Empployee");
			System.out.println("5. Exit");
			
			System.out.print("Your Option[1,2,3,4,5]  : ");
			int option = Integer.parseInt(br.readLine());
			System.out.println();
			Employee emp = null;
			String status = "";
			int eno = 0;
			String ename = "";
			float esal = 0;
			String eaddr = "";
			
			switch (option) {
			case 1: 
				System.out.println("=======ADD Module======");
				System.out.println();
				System.out.print("Employee Number    : ");
				eno = Integer.parseInt(br.readLine());
				System.out.print("Employee Name      : ");
				ename = br.readLine();
				System.out.print("Employee Salary    : ");
				esal = Float.parseFloat(br.readLine());
				System.out.print("Employee Address   : ");
				eaddr = br.readLine();
				
				emp = new Employee();
				emp.setEno(eno);
				emp.setEname(ename);
				emp.setEsal(esal);
				emp.setEaddr(eaddr);
				
				status = employeeDao.add(emp);
				System.out.println();
				System.out.println(status);
				break;
			case 2:
				System.out.println("*******Search Module*******");
				System.out.println();
				System.out.print("Employee Number   : ");
				eno = Integer.parseInt(br.readLine());
				emp = employeeDao.search(eno);
				if(emp == null) {
					System.out.println("Employee Not Existed");
				}else {
					System.out.println("Employee Details");
					System.out.println("--------------------");
					System.out.println("Employee Number   : "+emp.getEno());
					System.out.println("Employee Name     : "+emp.getEname());
					System.out.println("Employee Salary   : "+emp.getEsal());
					System.out.println("Employee Address  : "+emp.getEaddr());
				}
				break;
			case 3:
				System.out.println("========Update Module=========");
				System.out.println();
				System.out.print("Employee Number   : ");
				eno = Integer.parseInt(br.readLine());
				emp = employeeDao.search(eno);
				if(emp == null) {
					System.out.println("Employee Not Existed!");
				}else {
					System.out.println("Employee Number    : "+emp.getEno());
					System.out.print("Employee Name[Old Value  : "+emp.getEname()+"] : ");
					String ename_New = br.readLine();
					System.out.print("Employee Salary[Old Value  : "+emp.getEsal()+"] : ");
					float esal_New = Float.parseFloat(br.readLine());
					System.out.print("Employee Address[Old Value  : "+emp.getEaddr()+"] : ");
					String eaddr_New = br.readLine();
					System.out.println();
					Employee emp_New = new Employee();
					emp_New.setEno(eno);
					emp_New.setEname(ename_New);
					emp_New.setEsal(esal_New);
					emp_New.setEaddr(eaddr_New);
					
					status = employeeDao.update(emp_New);
					System.out.println(status);
				}
				break;
			case 4:
				System.out.println("========Delete Module=======");
				System.out.println();
				System.out.print("Employee Number    : ");
				eno = Integer.parseInt(br.readLine());
				status = employeeDao.delete(eno);
				System.out.println();
				System.out.println(status);
				break;
			case 5:
				System.out.println("*******ThankQ for choosing this App*******");
				System.exit(0);
				break;
			default:
				System.out.println("Enter the option from 1,2,3,4,5");
				break;
			}
			
		}
		
		
		/*
		Employee emp = new Employee();
		emp.setEno(111);
		emp.setEname("AAA");
		emp.setEsal(5000);
		emp.setEaddr("Leh");
		
		String status = employeeDao.add(emp);
		System.out.println(status);
		*/
		/*
		Employee emp = employeeDao.search(111);
		if(emp == null) {
			System.out.println("Employee Not Existed");
		}else {
			System.out.println("Employee Detils");
			System.out.println("--------------------");
			System.out.println("Employee Number    : "+emp.getEno());
			System.out.println("Employee Name      : "+emp.getEname());
			System.out.println("Employee Salary    : "+emp.getEsal());
			System.out.println("Employee Address   : "+emp.getEaddr());
		}
		*/
		/*
		Employee emp = new Employee();
		emp.setEno(112);
		emp.setEname("XXY");
		emp.setEsal(5500);
		emp.setEaddr("Patna");
		String status = employeeDao.update(emp);
		System.out.println(status);
		*/
		/*
		String status = employeeDao.delete(111);
		System.out.println(status);
		*/
	}

}
