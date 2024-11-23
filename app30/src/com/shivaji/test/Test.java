package com.shivaji.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.validation.MapBindingResult;
import org.springframework.validation.ObjectError;

import com.shivaji.beans.User;
import com.shivaji.validator.UserValidator;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("/com/shivaji/resources/applicationContext.xml");
		
		User user = (User)context.getBean("userBean");
		user.getUserDetails();
		System.out.println();
		UserValidator userValidator = (UserValidator)context.getBean("userValidator");
		
		Map<String, String> map = new HashMap<String,String>();
		MapBindingResult results = new MapBindingResult(map, "com.shivaji.beans.User");
		userValidator.validate(user, results);
		
		List<ObjectError> list = results.getAllErrors();
		for(ObjectError error : list) {
			System.out.println(error.getDefaultMessage());
		}
		
		
	}

}
