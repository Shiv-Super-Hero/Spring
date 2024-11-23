package com.shivaji.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shivaji.beans.HelloBean;

public class ClientApp {
	public void wish() {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/shivaji/resources/applicationContext.xml");
		HelloBean helloBean = (HelloBean)context.getBean("helloBean");
		String message = helloBean.sayHello("Ganesha");
		System.out.println(message);
		
	}
}
