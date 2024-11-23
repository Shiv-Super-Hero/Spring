package com.shivaji.handler;

import org.springframework.context.ApplicationListener;

import com.shivaji.event.AccountEvent;

public class AccountEventHandler implements ApplicationListener<AccountEvent>{
	@Override
	public void onApplicationEvent(AccountEvent ae) {
		ae.generateLog();
	}
}
