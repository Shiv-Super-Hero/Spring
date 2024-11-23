package com.shivaji.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.shivaji.controller.StudentController;
import com.shivaji.controller.StudentControllerImpl;
import com.shivaji.dao.StudentDao;
import com.shivaji.dao.StudentDaoImpl;
import com.shivaji.service.StudentService;
import com.shivaji.service.StudentServiceImpl;

import oracle.jdbc.pool.OracleDataSource;

@Configuration
public class AppConfig {
	
	@Bean
	public OracleDataSource oracleDataSource() {
		OracleDataSource oracleDataSource = null;
		try {
			oracleDataSource = new OracleDataSource();
			oracleDataSource.setURL("jdbc:oracle:thin:@localhost:1521:xe");
			oracleDataSource.setUser("system");
			oracleDataSource.setPassword("durga");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return oracleDataSource;
	}
	
	
	@Bean
	public StudentDao studentDao() {
		StudentDao studentDao = new StudentDaoImpl();
		return studentDao;
	}
	
	@Bean
	public StudentService studentService() {
		StudentService studentService = new StudentServiceImpl();
		return studentService;
	}
	
	@Bean
	public StudentController studentController() {
		StudentController studentController = new StudentControllerImpl();
		return studentController;
	}
}
