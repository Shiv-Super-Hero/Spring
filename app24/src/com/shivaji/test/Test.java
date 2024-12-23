package com.shivaji.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shivaji.controller.StudentController;

public class Test {

	public static void main(String[] args)throws Exception{
		ApplicationContext context = new ClassPathXmlApplicationContext("/com/shivaji/resources/applicationContext.xml");
		StudentController studentController = (StudentController)context.getBean("studentController");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("1. ADD ");
			System.out.println("2. SEARCH");
			System.out.println("3. UPDATE");
			System.out.println("4. DELETE");
			System.out.println("5. EXIT");
			
			System.out.print("Your Options [1 2 3 4 5]  : ");
			int option = Integer.parseInt(br.readLine());
			
			switch(option) {
				case 1:
					studentController.addStudent();
					System.out.println();
					break;
				
				case 2:
					studentController.searchStudent();
					System.out.println();
					break;
				
				case 3:
					studentController.updateStudent();
					System.out.println();
					break;
				
				case 4:
					studentController.deleteStudent();
					System.out.println();
					break;
				
				case 5:
					System.out.println("=*=*=*ThankQ For Using This Application*=*=*=");
					System.exit(0);
					break;
				
				default:
					System.out.println("Enter the option from 1,2,3,4and 5");
					break;
			}
		}
	}

}
