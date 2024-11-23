package com.shivaji.beans;

public class WishBean {
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
		System.out.println("init()-WishBean");
		name=" Salim";
		message="Anarkali Disco Chali";
	}
	private void destroy() {
		System.out.println("destroy()-WishBean");
	}
	private void localInit() {
		System.out.println("localInit()-WishBean");
		name="AAA";
		message="Good To See You Today Morning";
	}
	private void localDestroy() {
		System.out.println("localDestroy()-WishBean");
	}
	public String greetWish() {
		return "Good Morning "+name+", "+message;
	}
}
