package com.shivaji.dao;

import java.util.List;

import com.shivaji.dto.Employee;

public interface EmployeeDao {
	public int[] insert(List<Employee> empList);
	public int[] update();
}
