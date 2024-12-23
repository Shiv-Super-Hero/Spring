package com.shivaji.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.shivaji.beans.Account;
import com.shivaji.exception.InSufficientFundsException;

@Component("aspect")
@Aspect
public class TransactionAspect {
	@Before("execution (* com.shivaji.service.TransactionService.*(..))")
	public void before(JoinPoint jp) {
		Object[] params = jp.getArgs();
		Account acc = (Account) params[0];
		System.out.println("Before Advice  : Initial Balance  :  "+acc.getBalance());
	}
	
	@After("execution(* com.shivaji.service.TransactionService.*(..))")
	public void after(JoinPoint jp) {
		Object[] params = jp.getArgs();
		Account acc = (Account) params[0];
		System.out.println("After Advice  : Total Balance  :  "+acc.getBalance());
	}
	
	@AfterReturning(pointcut = "execution(* com.shivaji.service.TransactionService.*(..))", returning="results")
	public void afterReturning(JoinPoint jp, String results) {
		System.out.println("Transaction Status : "+results);
	}
	
	@Around("execution(* com.shivaji.service.TransactionService.*(..))")
	public void around(ProceedingJoinPoint pjp) {
		System.out.println("Around Advice : Before "+pjp.getSignature().getName()+" Method Execution");
		String status = "";
		try {
			status = (String)pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("Around Advice  :  After "+pjp.getSignature().getName()+" Method Execution");
		System.out.println("Around Advice  :  Transaction Status  :  "+status);
	}
	
	@AfterThrowing(pointcut="execution(* com.shivaji.service.TransactionService.*(..))", throwing="exception")
	public void afterThrowing(JoinPoint jp, InSufficientFundsException exception) {
		System.out.println("After Throwing  :  "+exception.getClass().getName()+" In Transaction  :  "+exception.getMessage());
	}
	
}
