package com.shivaji.dao;

import com.shivaji.entity.Employee;

public interface EmployeeDao {
	public String insertEmployee(Employee emp);
	public Employee findEmployee(int eno);
	public String updateEmployee(Employee emp);
	public String removeEmployee(int eno);
}
