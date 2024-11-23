package com.shivaji.dao;

import com.shivaji.dto.Student;

public interface StudentDao {
	public String add(Student student);
	public Student search(String sid);
	public String update(Student student);
	public String delete(String sid);
}
