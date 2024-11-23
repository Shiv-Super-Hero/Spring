package com.shivaji.beans;

public class HelloBean {
	private String name;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public String sayHello() {
		return "Hello "+name+"!";
	}
}
