package com.shivaji.service;

import com.shivaji.beans.Student;

public interface InstituteService {
	public void enquiry(Student std, String course_Name);
	public void registration(Student std, String course_Name);
}
