package com.shivaji.factory;

import com.shivaji.dao.StudentDao;
import com.shivaji.dao.StudentDaoImpl;

public class StudentDaoFactory {
	private static StudentDao studentDao;
	static {
		studentDao = new StudentDaoImpl();
	}
	public static StudentDao getStudentDao() {
		return studentDao;
	}
}
