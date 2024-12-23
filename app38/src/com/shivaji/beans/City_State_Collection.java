package com.shivaji.beans;

import java.util.ArrayList;

public class City_State_Collection {
	private ArrayList<City_State> cityState = new ArrayList<City_State>();
	public ArrayList<City_State> getCityState(){
		City_State c1 = new City_State();
		c1.setCity("Pune");
		c1.setState("Maharastra");
		
		City_State c2 = new City_State();
		c2.setCity("Goa");
		c2.setState("Goa");
		
		City_State c3 = new City_State();
		c3.setCity("Dispur");
		c3.setState("Assam");
		
		City_State c4 = new City_State();
		c4.setCity("Vizag");
		c4.setState("Telengana");
		
		City_State c5 = new City_State();
		c5.setCity("Jaankpur");
		c5.setState("Madhesh");
		
		City_State c6 = new City_State();
		c6.setCity("Kathmandu");
		c6.setState("Bagmati");
		
		cityState.add(c1);
		cityState.add(c2);
		cityState.add(c3);
		cityState.add(c4);
		cityState.add(c5);
		cityState.add(c6);
		
		return cityState;
	}
	
}
