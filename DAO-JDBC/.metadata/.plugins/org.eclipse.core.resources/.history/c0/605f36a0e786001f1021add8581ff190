package com.shivaji.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.shivaji.dto.Employee;

public class EmployeeDaoImpl implements EmployeeDao{
	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public String add(Employee emp) {
		String status = "";
		try {
			String query = "insert into emp1 values(?,?,?,?)";
			int rowCount = jdbcTemplate.update(query,emp.getEno(),emp.getEname(),emp.getEsal(),emp.getEaddr());
			if(rowCount == 1) {
				status = "Employee Inserted Successfully";
			}else {
				status = "Employee Insertion Failure";
			}
		} catch (Exception e) {
			status = "Employee Insertion Failure";
			e.printStackTrace();
		}
		return status;
	}
}
