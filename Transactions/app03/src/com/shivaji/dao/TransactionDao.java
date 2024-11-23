package com.shivaji.dao;

public interface TransactionDao {
	public String transferFunds(String fromAccount, String toAccount, int transferAmount);
	public String deposit(String accNo, int depAmt);
	public String withDraw(String accNo, int wdAmt);
}
