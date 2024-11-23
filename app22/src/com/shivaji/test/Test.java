package com.shivaji.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shivaji.beans.Account;
import com.shivaji.beans.Address;
import com.shivaji.beans.Employee;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("/com/shivaji/resources/applicationContext.xml");
		
		//Account account = (Account)context.getBean("acc");
		//Address address = (Address)context.getBean("addr");
		Employee employee = (Employee)context.getBean("empBean");
		employee.getEmpDetails();
	}
}

// In case of autowire byName we have to provide exactly same bean id attribute as in the caller bean class. In this
// example caller bean is Employee and id attribute to be provided are acc and addr.

// In case of autowire 'byType' if we have two beans with same type then error like such will arise[No qualifying 
// bean of type 'com.shivaji.beans.Account' available: expected single matching bean but found 2: accBean1,accBean2]

// If above problem arises then either go [autowire="byName"] or apply [autowire-candidate="false"] to that particular bean
// which we don't want to include.

