package com.shivaji.dao;

import com.shivaji.dto.Student;

public interface StudentDao {
	public String add(Student std);
	public Student search(String sid);
	public String delete(String sid);
}
