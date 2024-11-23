package com.shivaji.advice;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

import com.shivaji.beans.Student;

public class ThanqAdvice implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] params, Object target) throws Throwable {
		Student std = (Student) params[0];
		String courseName = (String) params[1];
		System.out.println("***********************************************************************");
		System.out.println("ThanQ "+std.getSname()+" for your course "+method.getName()+" on "+courseName);
		System.out.println("Shivaji Foundation Team will contact with you for the Course Schedule");
		System.out.println("***********************************************************************");
		
	}

}
