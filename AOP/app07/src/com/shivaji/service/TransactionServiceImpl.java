package com.shivaji.service;

import org.springframework.stereotype.Component;

import com.shivaji.beans.Account;
import com.shivaji.exception.InSufficientFundsException;

@Component("transaction")
public class TransactionServiceImpl implements TransactionService {

	@Override
	public String withdraw(Account acc, int wd_Amt) throws InSufficientFundsException {
		String status="";
		if(acc.getBalance() > wd_Amt) {
			int total_Bal = acc.getBalance()-wd_Amt;
			acc.setBalance(total_Bal);
			System.out.println("From Withdraw() : Transaction Withdraw Completed");
			status="SUCCESS";
		}else {
			status="FAILURE";
			throw new InSufficientFundsException("Funds are not sufficient in Your Account");
		}
		
		return status;
	}

}
