package com.shivaji.dao;

import com.shivaji.dto.Employee;

public interface EmployeeDao {
	public void insertEmployee(Employee emp);
	public Employee readEmployee(int eno);
}