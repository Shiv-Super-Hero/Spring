package com.shivaji.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shivaji.beans.HelloBean;
import com.shivaji.beans.WelcomeBean;
import com.shivaji.config.AppConfig;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		/*
		String[] beanNames = context.getBeanDefinitionNames();
		
		for(String beanName:beanNames) {
			System.out.println(beanName);
		}
		*/
		/*
		WelcomeBean welcomeBean = (WelcomeBean)context.getBean("welcomeBean");
		System.out.println(welcomeBean.getWelcomeMessage());
		
		HelloBean helloBean =(HelloBean) context.getBean("helloBean");
		System.out.println(helloBean.sayHello());
		*/
	}

}
