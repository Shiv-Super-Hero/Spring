package com.shivaji.service;

import com.shivaji.beans.Account;
import com.shivaji.exception.InSufficientFundsException;

public interface TransactionService {
	public String withdraw(Account acc, int wd_Amt)throws InSufficientFundsException;
}
