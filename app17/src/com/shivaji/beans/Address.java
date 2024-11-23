package com.shivaji.beans;

public class Address {
	private String pno;
	private String street;
	private String city;
	private String state;
	private String country;
	
	public String getPno() {
		return pno;
	}
	public void setPno(String pno) {
		this.pno = pno;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public void getAddressDetails() {
		System.out.println("Address Details");
		System.out.println("Plot Number      : "+pno);
		System.out.println("Street Name      : "+street);
		System.out.println("City Name        : "+city);
		System.out.println("State Name       : "+state);
		System.out.println("Country Name     : "+country);
	}
}
