package com.shivaji.beans;

public class HelloBean {
	static {
		System.out.println("Hello Bean Class Loading...");
	}
	public HelloBean() {
		System.out.println("Hello Bean Instantiation...");
	}
	public String sayHello() {
		return "Hello User!";
	}
	public static HelloBean getInstance() {
		System.out.println("Static Factory Method");
		return new HelloBean();
	}
}
