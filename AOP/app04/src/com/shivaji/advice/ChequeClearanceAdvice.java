package com.shivaji.advice;

import org.aopalliance.intercept.MethodInterceptor; 
import org.aopalliance.intercept.MethodInvocation;

import com.shivaji.beans.Account;
import com.shivaji.beans.Cheque;

public class ChequeClearanceAdvice implements MethodInterceptor{
	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		Object[] params = mi.getArguments();
		Account acc = (Account) params[0];
		Cheque cheque = (Cheque) params[1];
		
		System.out.println("Hello "+acc.getAccHolderName()+"!, Cheque No "+cheque.getCheque_No()+" is coming for Clearance with an Amount "+cheque.getAmount());
		mi.proceed();
		System.out.println("Hello "+acc.getAccHolderName()+"!, Account Number "+acc.getAccNo()+" has been debited the amount "+cheque.getAmount()+" in clearance of the Cheque No "+cheque.getCheque_No()+" , Now the Total Amount in your Account is "+acc.getBalance());
		
		return null;
	}
	
	
}
