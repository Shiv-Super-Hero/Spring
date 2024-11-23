package com.shivaji.beans;

public class DBBean {
	private String driverClass;
	private String driverUrl;
	private String dbUserName;
	private String dbPassword;
	
	public String getDriverClass() {
		return driverClass;
	}
	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}
	public String getDriverUrl() {
		return driverUrl;
	}
	public void setDriverUrl(String driverUrl) {
		this.driverUrl = driverUrl;
	}
	public String getDbUserName() {
		return dbUserName;
	}
	public void setDbUserName(String dbUserName) {
		this.dbUserName = dbUserName;
	}
	public String getDbPassword() {
		return dbPassword;
	}
	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}
	public void displayDBDetails() {
		System.out.println("Database Details");
		System.out.println("---------------------");
		System.out.println("Driver Class Name   : "+driverClass);
		System.out.println("Driver URL          : "+driverUrl);
		System.out.println("Database User Name  : "+dbUserName);
		System.out.println("Database Password   : "+dbPassword);
	}
}
