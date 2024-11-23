package com.shivaji.test;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shivaji.beans.Account;
import com.shivaji.beans.Employee;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("/com/shivaji/resources/applicationContext.xml");
		Employee emp = (Employee)context.getBean("employee");
		emp.getEmployeeDetails();
	}

}

// In order to use @Autowired annotations we have to write [ <context:annotation-config/> ] tag just above the bean over
// which the annotation is to be applied. In addition to this we have to write @Required annotation just above @Autowired or
// an alternative is to write @Autowired(required=true). @Autowired annotation is applied just above the setter method of the 
// bean to be injected in another bean. If there comes any ambiguity then [ @Qualifier("bean_Id") ] is used to resolve the
// ambiguity. @Qualifier is not that much easy to use use above Constructor in case of Constructor Injection so it is used 
// in unique way as here. [ public Employee(String eid,String ename,float esal,String eaddr, @Qualifier("currentAcc") Account acc) ]