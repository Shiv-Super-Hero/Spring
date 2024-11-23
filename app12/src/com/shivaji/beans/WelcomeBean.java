package com.shivaji.beans;

public class WelcomeBean {
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
	public String sayWelcome() {
		return "Hello "+name+", "+message;
	}
}
