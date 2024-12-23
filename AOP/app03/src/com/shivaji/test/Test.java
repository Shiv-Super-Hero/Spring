package com.shivaji.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shivaji.beans.Movie;
import com.shivaji.service.MovieService;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("/com/shivaji/resources/applicationContext.xml");
		Movie movie = (Movie)context.getBean("movieBean");
		
		MovieService movieService = (MovieService)context.getBean("proxy");
		try {
			movieService.playMovie(movie);
		} catch (Exception e) {
			
		}
		
	}

}
