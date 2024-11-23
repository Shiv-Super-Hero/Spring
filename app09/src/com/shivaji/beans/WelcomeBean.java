package com.shivaji.beans;

public class WelcomeBean {
	static {
		System.out.println("WelcomeBean Class Loading...");
	}
	public WelcomeBean() {
		System.out.println("WelcomeBean Class Instantiation...");
	}
	private String name;
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public String getWelcomeMessage() {
		return "Hello "+name+" , Welcome To Chhatrapati Shivaji Maratha Samarajya";
	}
}
