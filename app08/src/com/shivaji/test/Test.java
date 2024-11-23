package com.shivaji.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shivaji.beans.HelloBean;
import com.shivaji.scopes.ThreadScope;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("/com/shivaji/resources/applicationContext.xml");
		HelloBean helloBean1 = (HelloBean)context.getBean("helloBean");
		HelloBean helloBean2 = (HelloBean)context.getBean("helloBean");
		System.out.println(helloBean1.sayHello());
		System.out.println(helloBean2.sayHello());
		
		System.out.println(helloBean1);
		System.out.println(helloBean2);
		
		Runnable r = new Runnable() {
			@Override
			public void run() {
				HelloBean helloBean3 = (HelloBean)context.getBean("helloBean");
				HelloBean helloBean4 = (HelloBean)context.getBean("helloBean");
				System.out.println("User Thread  : "+helloBean3);
				System.out.println("User Thread  : "+helloBean4);
				
			}
		};
		Thread t1 = new Thread(r);
		t1.start();
		
		
		new Thread(() -> {
			HelloBean helloBean5 = (HelloBean)context.getBean("helloBean");
			HelloBean helloBean6 = (HelloBean)context.getBean("helloBean");
			System.out.println("User Thread2  : "+helloBean5);
			System.out.println("User Thread2  : "+helloBean6);
		}).start();
		
	}

}
