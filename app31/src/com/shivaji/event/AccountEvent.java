package com.shivaji.event;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;

import org.springframework.context.ApplicationEvent;

public class AccountEvent extends ApplicationEvent {

	private String message;
	private static FileOutputStream fos;
	
	static{
		try {
			fos = new FileOutputStream("D://FileHistory//Shiv Narayan Singh//program_purpose//log.txt",true);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public AccountEvent(Object obj,String message) {
		super(obj);
		this.message = message;
	}
	public void generateLog() {
		try {
			message = new Date().toString()+" : "+message;
			byte[] b = message.getBytes();
			fos.write(b);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
