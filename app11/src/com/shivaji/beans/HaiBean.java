package com.shivaji.beans;

public class HaiBean {
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
		System.out.println("init()-HaiBean");
		name="TodarMahal";
		message="Aaj ka Hisaab Sunaao";
	}
	private void destroy() {
		System.out.println("destroy()-HaiBean");
	}
	public String sayHai() {
		return "Hai "+name+", "+message;
	}
}
