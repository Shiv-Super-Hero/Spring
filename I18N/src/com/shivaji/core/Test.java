package com.shivaji.core;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

public class Test {

	public static void main(String[] args) {
		//Locale l = new Locale("it","IT");
		Locale l = new Locale("en","US");
		NumberFormat numberFormat = NumberFormat.getInstance(l);
		System.out.println(numberFormat.format(793776323691.65237));
		
		DateFormat dateFormat = DateFormat.getDateInstance(0, l);
		System.out.println(dateFormat.format(new Date()));
	}

}

// In line 16 in place of .getInstance() method first parameter we can also write 1 or 2 or 3 but not 4 and above numbers.