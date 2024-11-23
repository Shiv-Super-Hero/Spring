package com.shivaji.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.shivaji.dto.Employee;

public class EmployeeRowMapper implements RowMapper<Employee> {
	@Override
	public Employee mapRow(ResultSet rs, int arg1) throws SQLException {
		Employee emp = new Employee();
		emp.setEno(rs.getInt("ENO"));
		emp.setEname(rs.getString("ENAME"));
		emp.setEsal(rs.getFloat("ESAL"));
		emp.setEaddr(rs.getString("EADDR"));
		return emp;
	}
}
