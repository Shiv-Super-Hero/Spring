package com.shivaji.beans;

public class HelloBean {
	static {
		System.out.println("HelloBean Class Loading...");
	}
	public HelloBean() {
		System.out.println("HelloBean Class Instantiation...");
	}
	public String sayHello() {
		return "Hello User !";
	}
}
