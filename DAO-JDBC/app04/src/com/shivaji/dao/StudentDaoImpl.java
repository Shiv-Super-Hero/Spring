package com.shivaji.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.shivaji.dto.Student;

public class StudentDaoImpl implements StudentDao {

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
	@Override
	public String add(Student std) {
		String status = "";
		String query = "";
		try {
			query = "select * from student where SID = :sid";
			Map<String, Object> params = new HashMap<String,Object>();
			params.put("sid", "S-444");
			List<Student> studentList = namedParameterJdbcTemplate.query(query, params,(rs,index) -> {
				Student std1 = new Student();
				std1.setSid(rs.getString("SID"));
				std1.setSname(rs.getString("SNAME"));
				std1.setSaddr(rs.getString("SADDR"));
				return std1;
			});
			if(studentList.isEmpty() == true) {
				query = "insert into student values(:sid, :sname, :saddr)";
				params = new HashMap<String,Object>();
				params.put("sid", std.getSid());
				params.put("sname", std.getSname());
				params.put("saddr", std.getSaddr());
				int rowCount = namedParameterJdbcTemplate.update(query, params);
				if(rowCount == 1) {
					status = "Student Inserted Successfully.";
				}else {
					status="Student Insertion Failure.";
				}
				
			}else {
				status="Student Existed Already";
			}
		} catch (Exception e) {
			status = "Student Insertion Failure";
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public Student search(String sid) {
		Student std = null;
		
		try {
			String query = "select * from student where SID = :sid";
			Map<String, Object> params = new HashMap<String,Object>();
			params.put("sid", sid);
			List<Student> studentsList = namedParameterJdbcTemplate.query(query, params,(rs,index) -> {
				Student std1 = new Student();
				std1.setSid(rs.getString("SID"));
				std1.setSname(rs.getString("SNAME"));
				std1.setSaddr(rs.getString("SADDR"));
				return std1;
			});
			if(studentsList.isEmpty() == true) {
				std = null;
			}else {
				std = studentsList.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return std;
	}

	@Override
	public String update(Student std) {
		String status = "";
		try {
			Student std1 = search(std.getSid());
			if(std1 == null) {
				status = "Student Not Existed";
			}else {
				String query = "update student set SNAME = :sname, SADDR = :saddr where SID = :sid";
				Map<String, Object> params = new HashMap<String,Object>();
				params.put("sid", std.getSid());
				params.put("sname", std.getSname());
				params.put("saddr", std.getSaddr());
				int rowCount = namedParameterJdbcTemplate.update(query, params);
				if(rowCount == 1) {
					status = "Student Updation Success";
				}else {
					status = "Student Updation Failue";
				}
			}
		} catch (Exception e) {
			status = "Student Updation Failure";
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public String delete(String sid) {
		String status = "";
		try {
			Student std = search(sid);
			if(std == null) {
				status = "Styudent Not Existed";
			}else {
				String query = "delete from student where SID = :sid";
				Map<String, Object> params = new HashMap<String,Object>();
				params.put("sid", sid);
				int rowCount = namedParameterJdbcTemplate.update(query, params);
				if(rowCount == 1) {
					status = "Status Deletion Success";
				}else {
					status = "Student Deletion Failure";
				}
			}
		} catch (Exception e) {
			status = "Student Deletion Failure";
			e.printStackTrace();
		}
		return status;
	}

}
