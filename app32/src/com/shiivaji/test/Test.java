package com.shiivaji.test;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class Test {

	public static void main(String[] args) {
		//Locale locale = new Locale("it","IT");
		Locale locale = new Locale("en","US");
		NumberFormat numberFormat = NumberFormat.getInstance(locale);
		System.out.println(numberFormat.format(65814237.3572812));
		
		DateFormat dateFormat = DateFormat.getDateInstance(0, locale);
		System.out.println(dateFormat.format(new Date()));
		
		ResourceBundle resourceBundle = ResourceBundle.getBundle("abc",locale);
		System.out.println(resourceBundle.getString("welcome"));
	}

}
