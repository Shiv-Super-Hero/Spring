package com.shivaji.dao;

import com.shivaji.dto.StudentTo;

public interface StudentDao {
	public String addStudent(StudentTo sto);
	public StudentTo search(String sid);
	public String update(StudentTo sto);
	public String delete(String sid);
}
