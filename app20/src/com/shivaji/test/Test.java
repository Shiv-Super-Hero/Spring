package com.shivaji.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shivaji.beans.Account;
import com.shivaji.beans.Employee;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("/com/shivaji/resources/applicationContext.xml");
		Account acc =(Account) context.getBean("accBean");
		
		Employee emp = (Employee)context.getBean("empBean");
		emp.getEmpDetails();
	}
}

// Using P-Namespace we can easily eliminate the use of property tag inside bean tag. Same functionality we can get through
// using p-namespace. This method is applicable for only setter injection. For constructor injection there is another mechanism 
// called as C-Namespace. If we want to execute our program by using both inline and property tag approach then definitely we
// are going to get some exception.

//Exception in thread "main" org.springframework.beans.factory.parsing.BeanDefinitionParsingException: Configuration problem: 
// Property 'accNo' is already defined using both <property> and inline syntax. Only one approach may be used per property.
//Offending resource: class path resource [com/shivaji/resources/applicationContext.xml]

// Configuration Details is provided in applicationContext.xml file.