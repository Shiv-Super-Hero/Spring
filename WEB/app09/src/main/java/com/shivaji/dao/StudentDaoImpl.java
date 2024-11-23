package com.shivaji.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import com.shivaji.dto.StudentTo;

public class StudentDaoImpl implements StudentDao {

	private JdbcTemplate jdbcTemplate;
	String status = "";
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public String addStudent(StudentTo sto) {
		String query1 = "select * from student where SID = '"+sto.getSid()+"'";
		List<StudentTo> list = jdbcTemplate.query(query1, (rs , i) -> {
			StudentTo std_Entity = new StudentTo();
			std_Entity.setSid(rs.getString("SID"));
			std_Entity.setSname(rs.getString("SNAME"));
			std_Entity.setSaddr(rs.getString("SADDR"));
			return std_Entity;
		});
		if(list.isEmpty()) {
			String query2 = "insert into student values('"+sto.getSid()+"','"+sto.getSname()+"','"+sto.getSaddr()+"')";
			int rowCount = jdbcTemplate.update(query2);
			if(rowCount == 1) {
				status = "success";
			}else {
				status = "failure";
			}
			
		}else {
			status = "existed";
		}
		
		return status;
	}

	@Override
	public StudentTo search(String sid) {
		StudentTo sto = null;
		String query = "select * from student where SID = '"+sid+"'";
		List<StudentTo> std_List = jdbcTemplate.query(query, (resultSet,i) -> {
			StudentTo std_Entity = new StudentTo();
			std_Entity.setSid(resultSet.getString("SID"));
			std_Entity.setSname(resultSet.getString("SNAME"));
			std_Entity.setSaddr(resultSet.getString("SADDR"));
			
			return std_Entity;
		});
		if(std_List.isEmpty()) {
			sto = null;
		}else {
			sto = std_List.get(0);
		}
		return sto;
	}

	@Override
	public String update(StudentTo sto) {
		String query = "update student set SNAME = '"+sto.getSname()+"',SADDR = '"+sto.getSaddr()+"'where SID = '"+sto.getSid()+"'";
		int rowCount = jdbcTemplate.update(query);
		if(rowCount == 1) {
			status = "success";
		}else {
			status = "failure";
		}
		
		return status;
	}

	@Override
	public String delete(String sid) {
		String query = "select * from student where SID = '"+sid+"'";
		List<StudentTo> std_List = jdbcTemplate.query(query, (rs , i) -> {
			StudentTo std_Entity = new StudentTo();
			std_Entity.setSid(rs.getString("SID"));
			std_Entity.setSname(rs.getString("SNAME"));
			std_Entity.setSaddr(rs.getString("SADDR"));
			return std_Entity;
		});
		if(std_List.isEmpty()) {
			status = "notexisted";
		}else {
			String query1 = "delete from student where SID = '"+sid+"'";
			int rowCount = jdbcTemplate.update(query1);
			if(rowCount == 1) {
				status = "success";
			}else {
				status = "failure";
			}
		}
		return status;
	}
}
