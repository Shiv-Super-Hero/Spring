package com.shivaji.advice;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;

public class MoneyReturnAdvice implements ThrowsAdvice{
	public void afterThrowing(Method method, Object[] params, Object target, Exception e) {
		System.out.println("**************************************************************************************************");
		System.out.println("Power Failure Exception Occured, Movie was stopped, Please come to Counter and Collect Your Money!");
		System.out.println("**************************************************************************************************");
	}
	
}
