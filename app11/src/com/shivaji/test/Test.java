package com.shivaji.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shivaji.beans.HaiBean;
import com.shivaji.beans.HelloBean;
import com.shivaji.beans.WishBean;

public class Test {

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("/com/shivaji/resources/applicationContext.xml");
		WishBean wishBean = (WishBean)context.getBean("wishBean");
		System.out.println(wishBean.greetWish());
		/*
		HelloBean helloBean = (HelloBean)context.getBean("helloBean");
		System.out.println(helloBean.sayHello());
		
		HaiBean haiBean = (HaiBean) context.getBean("haiBean");
		System.out.println(haiBean.sayHai());
		*/
		context.registerShutdownHook();
	}

}
