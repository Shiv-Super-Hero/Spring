package com.shivaji.dao;

import com.shivaji.dto.Employee;

public interface EmployeeDao {
	public String add(Employee emp);
	public Employee search(int eno);
	public String update(Employee emp);
	public String delete(int eno);
}
