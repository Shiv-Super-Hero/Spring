package com.shivaji.beans;

//import javax.annotation.PostConstruct; 
//import javax.annotation.PreDestroy;

//import javax.annotation.PostConstruct; 
//import javax.annotation.PreDestroy;

//import org.springframework.beans.factory.DisposableBean;
//import org.springframework.beans.factory.InitializingBean;

public class HelloBean{
	private String name;
	private String message;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void init() {
		System.out.println("init()-HelloBean");
		name="Birbal";
		message="Koi Buddhi Laagao!";
	}
	private void destroy() {
		System.out.println("destroy()-HelloBean");
	}
	public String sayHello() {
		return "Hello "+name+", "+message+"!";
	}
	
}
