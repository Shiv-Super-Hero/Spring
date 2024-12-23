package com.shivaji.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

import com.shivaji.dto.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public int[] insert(List<Employee> empList) {
		int[] rowCounts = null;
		try {
			String query = "insert into emp1 values(?,?,?,?)";
			rowCounts = jdbcTemplate.batchUpdate(query,new BatchPreparedStatementSetter() {
				
				@Override
				public void setValues(PreparedStatement ps, int index) throws SQLException {
					Employee emp = empList.get(index);
					ps.setInt(1, emp.getEno());
					ps.setString(2, emp.getEname());
					ps.setFloat(3, emp.getEsal());
					ps.setString(4, emp.getEaddr());
				}
				
				@Override
				public int getBatchSize() {
					return empList.size();
				}
			});			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowCounts;
	}
	@Override
	public int[] update() {
		int[] rowCounts = null;
		try {
			String query1 = "insert into emp1 values(555,'EEE',4000,'Leh')";
			String query2 = "update emp1 set ESAL = ESAL+500 where ESAL < 3100";
			String query3 = "delete from emp1 where ENO = 111";
			
			rowCounts = jdbcTemplate.batchUpdate(query1,query2,query3);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return rowCounts;
	}

}
