package com.shivaji.beans;

public class HelloBean {
	static {
		System.out.println("HelloBean Class Loading...");
	}
	public HelloBean() {
		System.out.println("HelloBean Class Instantiation...");
	}
	private String name;
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public String sayHello() {
		return "Hello "+name+"!, Good Morning!";
	}
}
