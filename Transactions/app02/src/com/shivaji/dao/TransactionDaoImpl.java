package com.shivaji.dao;

import org.springframework.jdbc.core.JdbcTemplate; 
public class TransactionDaoImpl implements TransactionDao {

	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public String transferFunds(String fromAccount, String toAccount, int transferAmount) {
		String status = "";
			int debitRowCount = debit(fromAccount,transferAmount);
			//float f = 100/0;
			int creditRowCount = credit(toAccount, transferAmount);
			if(debitRowCount == 1 && creditRowCount ==1) {
				status="Transaction Success";
			}
			else {
				status = "Transaction Failure";
			}	
		return status;
	}
	
	public int debit(String fromAccount, int transferAmount) {
		int rowCount = jdbcTemplate.update("update account set BALANCE = BALANCE -"+transferAmount+" where ACCNO = '"+fromAccount+"'");
		System.out.println(transferAmount+" is debited from "+fromAccount);
		return rowCount;
	}
	
	public int credit(String toAccount, int transferAmount) {
		int rowCount = jdbcTemplate.update("update account set BALANCE = BALANCE +"+transferAmount+" where ACCNO = '"+toAccount+"'");
		System.out.println(transferAmount+" is credited to "+toAccount);
		return rowCount;
	}
	
	

}
