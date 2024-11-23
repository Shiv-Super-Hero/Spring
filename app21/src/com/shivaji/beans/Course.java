package com.shivaji.beans;

public class Course {
	private String cid;
	private String cname;
	private int ccost;
	
	public Course(String cid,String cname, int ccost) {
		this.cid=cid;
		this.cname=cname;
		this.ccost=ccost;
	}
	public String getCid() {
		return cid;
	}
	public String getCname() {
		return cname;
	}
	public int getCcost() {
		return ccost;
	}
}
