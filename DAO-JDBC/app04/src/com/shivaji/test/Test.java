package com.shivaji.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shivaji.dao.StudentDao;
import com.shivaji.dto.Student;

public class Test {

	public static void main(String[] args) throws Exception{
		ApplicationContext context = new ClassPathXmlApplicationContext("/com/shivaji/resources/applicationContext.xml");
		StudentDao studentDao = (StudentDao)context.getBean("studentDao");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println();
			System.out.println("1. Add Student");
			System.out.println("2. Search Student");
			System.out.println("3. Update Student");
			System.out.println("4. Delete Student");
			System.out.println("5. Exit");
			System.out.print("Your Option[1,2,3,4,5] : ");
			int option = Integer.parseInt(br.readLine());
			System.out.println();
			
			String sid = "";
			String sname = "";
			String saddr = "";
			Student std = null;
			String status = "";
			
			switch(option) {
			case 1:
				System.out.println("*******ADD Student Module*******");
				System.out.print("Student Id      : ");
				sid = br.readLine();
				System.out.print("Student Name    : ");
				sname = br.readLine();
				System.out.print("Student Address : ");
				
				saddr = br.readLine();
				std = new Student();
				std.setSid(sid);
				std.setSname(sname);
				std.setSaddr(saddr);
				status = studentDao.add(std);
				System.out.println(status);
				
				break;
			case 2:
				System.out.println("*******SEARCH Student Module*******");
				System.out.print("Student Id    : ");
				sid = br.readLine();
				
				std = studentDao.search(sid);
				if(std == null) {
					System.out.println("Student Not Existed");
				}else {
					System.out.println("Student Details");
					System.out.println("--------------------");
					System.out.println("Student Id      : "+std.getSid());
					System.out.println("Student Name    : "+std.getSname());
					System.out.println("Student Address : "+std.getSaddr());
				}
				
				break;
			case 3:
				System.out.println("*******UPDATE Student Module*******");
				System.out.print("Student Id        : ");
				sid = br.readLine();
				System.out.print("Student Name      : ");
				sname = br.readLine();
				System.out.print("Student Address   : ");
				saddr = br.readLine();
				
				std = new Student();
				std.setSid(sid);
				std.setSname(sname);
				std.setSaddr(saddr);
				status = studentDao.update(std);
				System.out.println(status);
				
				break;
			case 4:
				System.out.println("*******DELETE Student Module*******");
				System.out.print("Student Id     : ");
				sid = br.readLine();
				
				status = studentDao.delete(sid);
				System.out.println(status);
				
				break;
			case 5:
				System.out.println("====ThankQ for Using This Application====");
				System.exit(0);
				break;
			default:
				System.out.println("Enter the option from 1,2,3,4,5");
				break;
			}
			
		}
		
		/*
		Student std = new Student();
		std.setSid("S-444");
		std.setSname("DDD");
		std.setSaddr("Leh");
		String status = studentDao.add(std);
		System.out.println(status);
		*/
		/*
		Student std = studentDao.search("S-111");
		if(std == null) {
			System.out.println("Student Not Existed");
		}else {
			System.out.println("Student Details");
			System.out.println("--------------------");
			System.out.println("Student Id      : "+std.getSid());
			System.out.println("Student Name    : "+std.getSname());
			System.out.println("Student Address : "+std.getSaddr());
		}
		*/
		/*
		Student std = new Student();
		std.setSid("S-222");
		std.setSname("XXX");
		std.setSaddr("Patna");
		String status = studentDao.update(std);
		System.out.println(status);
		*/
		/*
		String status = studentDao.delete("S-444");
		System.out.println(status);
		*/
	}

}
