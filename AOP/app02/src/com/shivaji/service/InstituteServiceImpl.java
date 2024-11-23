package com.shivaji.service;

import com.shivaji.beans.Student;

public class InstituteServiceImpl implements InstituteService {

	@Override
	public void enquiry(Student std, String course_Name) {
		System.out.println("Enquiry Student Details");
		System.out.println("-----------------------------");
		System.out.println("Student Name     : "+std.getSname());
		System.out.println("Student Qual     : "+std.getSqual());
		System.out.println("Student Mobile   : "+std.getSmobile());
		System.out.println("Student Course   : "+course_Name);	
	}

	@Override
	public void registration(Student std, String course_Name) {
		System.out.println("Student Registration Details");
		System.out.println("-----------------------------");
		System.out.println("Student Name     : "+std.getSname());
		System.out.println("Student Qual     : "+std.getSqual());
		System.out.println("Student Mobile   : "+std.getSmobile());
		System.out.println("Student Course   : "+course_Name);	
	}
	}

