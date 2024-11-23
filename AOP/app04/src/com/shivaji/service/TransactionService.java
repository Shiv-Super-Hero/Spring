package com.shivaji.service;

import com.shivaji.beans.Account;
import com.shivaji.beans.Cheque;

public interface TransactionService {
	public void debit(Account acc, Cheque cheque);
}
