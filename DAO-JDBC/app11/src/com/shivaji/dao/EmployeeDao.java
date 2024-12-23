package com.shivaji.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import com.shivaji.dto.Employee;

public interface EmployeeDao {
	public void create(Employee emp);
	public Object getEmpSal(int eno);
	public Employee getEmployee(int eno);
	public void updateEmployee(Employee emp);
	public void deleteEmployee(int eno);
	public List<Employee> getAllEmployees();
}
