package com.shivaji.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shivaji.beans.Course;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("/com/shivaji/resources/applicationContext.xml");
		
		Course course = (Course)context.getBean("courseBean");
		System.out.println();
		course.getCourseDetails();
		System.out.println();
		
		/*
		Course course1 = (Course)context.getBean("courseBean1");
		course1.getCourseDetails();
		System.out.println();
		Course course3 = (Course)context.getBean("courseBean3");
		course3.getCourseDetails();
		System.out.println();
		Course course4 = (Course)context.getBean("courseBean4");
		course4.getCourseDetails();
		*/
	}

}
