package com.shivaji.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shivaji.beans.Course;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("/com/shivaji/resources/applicationContext.xml");
		Course course = (Course)context.getBean("courseBean");
		course.getCourseDetails();
		
	}

}

// This program shows that we are providing the IOC Container to replace the method not to execute the ordinary method
// rather it should execute the newly defined method.