package com.shivaji.beans;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;

public class MethodReplacerImpl implements MethodReplacer {

	@Override
	public Object reimplement(Object arg0, Method arg1, Object[] arg2) throws Throwable {
		System.out.println("Course Details");
		System.out.println("-------------------");
		System.out.println("Course Id       : C-222");
		System.out.println("Course Name     : Python");
		System.out.println("Course Cost     : 8000");
		
		return null;
	}

}
