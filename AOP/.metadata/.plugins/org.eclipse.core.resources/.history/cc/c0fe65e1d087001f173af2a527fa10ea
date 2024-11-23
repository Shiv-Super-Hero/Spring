package com.shivaji.advice.validator;

import java.lang.reflect.Method; 

import org.springframework.aop.MethodBeforeAdvice;

import com.shivaji.beans.Employee;

public class EmployeeValidatorAdvice implements MethodBeforeAdvice {
	
	@Override
	public void before(Method method, Object[] params, Object target) throws Throwable {
		Employee emp = (Employee)params[0];
		System.out.println("Validation Messages for "+method.getName());
		System.out.println("---------------------------------------");
		
		if(emp.getEno() < 100 || emp.getEno() > 999) {
			System.out.println("***********Employee Number Must be 3 digit Number*********");
		}
		if(emp.getEsal() < 20000 || emp.getEsal() > 50000) {
			System.out.println("***********Employee Salary Must be in the range of 20000 to 50000");
		}
		if(!emp.getEmobile().startsWith("+91-")) {
			System.out.println("***********Employee Mobile Number Invalid***************");
		}
		if(!emp.getEemail().endsWith("@gmail.com")) {
			System.out.println("***********Employee Email Id is Invalid***************");
		}
		
	}

}
