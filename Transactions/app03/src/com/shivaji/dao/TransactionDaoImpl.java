package com.shivaji.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import com.shivaji.beans.Account;
public class TransactionDaoImpl implements TransactionDao {

	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Transactional
	@Override
	public String withDraw(String accNo, int wdAmt) {
		String status = "";
		List<Object> list = jdbcTemplate.query("select * from account where ACCNO='"+accNo+"'", (rs , index) -> {
			Account acc = new Account();
			acc.setAccNo(rs.getString("ACCNO"));
			acc.setBalance(rs.getInt("BALANCE"));
			return acc;
		});
		int balance = ((Account)list.get(0)).getBalance();
		//System.out.println(balance);
		if(balance <= wdAmt) {
			status = "Transaction Failure";
			throw new RuntimeException("Insufficient Funds In Your Account");
		}else {
			int debitRowCount = debit(accNo, wdAmt);
			if(debitRowCount == 1) {
				status = "Transaction Success";
			}else {
				status = "Transaction Failure";
			}
		}
		
		
		return status;
	}
	
	@Transactional
	@Override
	public String deposit(String accNo, int depAmt) {
		String status = "";
		int depositRowCount = credit(accNo, depAmt);
		if(depositRowCount == 1) {
			status = "Transaction Successful";
		}else {
			status = "Transaction Failure";
			throw new RuntimeException("Insufficient Details in the Transaction");
		}
		return status;
	}
	
	@Transactional
	@Override
	public String transferFunds(String fromAccount, String toAccount, int transferAmount) {
		String status = "";
			int debitRowCount = debit(fromAccount,transferAmount);
			float f = 100/0;
			int creditRowCount = credit(toAccount, transferAmount);
			if(debitRowCount == 1 && creditRowCount == 1) {
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
