package com.shivaji.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shivaji.beans.HelloBean;
import com.shivaji.beans.WelcomeBean;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("/com/shivaji/resources/applicationContext.xml");
		
		HelloBean helloBean = (HelloBean) context.getBean("helloBean");
		System.out.println(helloBean.sayHello());
		
		WelcomeBean welBean = (WelcomeBean)context.getBean("welcomeBean");
		System.out.println(welBean.sayWelcome());
	}

}
// Look in this Example we have not created any type of wishBean object in applicationContext.xml file neither we have created 
// object in main class of Test file just by simply declaring the bean wishBean abstract it is acting as the template for
// their child classes like helloBean and welcomeBean. 