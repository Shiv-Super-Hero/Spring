package com.shivaji.factory;

import com.shivaji.service.StudentService;
import com.shivaji.service.StudentServiceImpl;

public class StudentServiceFactory {
	private static StudentService studentService;
	static {
		studentService = new StudentServiceImpl();
	}
	public static StudentService getStudentService() {
		return studentService;
	}
}
