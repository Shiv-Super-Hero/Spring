package com.shivaji.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shivaji.beans.HelloBean;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("/com/shivaji/resources/applicationContext.xml");
		HelloBean helloBean = (HelloBean) context.getBean("helloBean");
		System.out.println(helloBean.sayHello());
	}
}
