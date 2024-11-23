package com.shivaji.factory;

import com.shivaji.beans.HelloBean;

public class HelloBeanFactory {
	public HelloBean getHelloBeanInstance() {
		System.out.println("getHelloBeanInstance()-HelloBeanFactory");
		return new HelloBean();
	}
}
