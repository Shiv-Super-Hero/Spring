package com.shivaji.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.shivaji.beans.HelloBean;
import com.shivaji.beans.WelcomeBean;

@Configuration
public class AppConfig {
	static {
		System.out.println("AppConfig Class Loading...");
	}
	public AppConfig() {
		System.out.println("AppConfig Class Instantiation...");
	}
	@Bean
	public HelloBean helloBean() {
		HelloBean helloBean = new HelloBean();
		helloBean.setName("Chinny");
		return helloBean;
	}
	@Bean
	public WelcomeBean welcomeBean() {
		WelcomeBean welcomeBean = new WelcomeBean();
		welcomeBean.setName("Raju");
		return  welcomeBean;
	}
}
