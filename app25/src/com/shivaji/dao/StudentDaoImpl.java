package com.shivaji.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.shivaji.dto.Student;

import oracle.jdbc.pool.OracleDataSource;

//@Component("studentDao")
@Repository("studentDao")
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private OracleDataSource oracleDataSource; 
	
	@Override
	public String add(Student student) {
		String status = "";
		try {
			Connection conn = oracleDataSource.getConnection();
			PreparedStatement pst = conn.prepareStatement("select * from student where SID = ?");
			pst.setString(1, student.getSid());
			ResultSet rs = pst.executeQuery();
			boolean b= rs.next();
			
			if(b == true) {
				status="existed";
			}
			else {
				pst = conn.prepareStatement("insert into student values(?,?,?)");
				pst.setString(1, student.getSid());
				pst.setString(2, student.getSname());
				pst.setString(3, student.getSaddr());
				int rowCount = pst.executeUpdate();
				
				if(rowCount == 1) {
					status = "success";
				}else {
					status = "failure";
				}	
			}
			
		} catch (Exception e) {
			status = "failure";
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public Student search(String sid) {
		Student student = null;
		try {
			Connection conn = oracleDataSource.getConnection();
			PreparedStatement pst = conn.prepareStatement("select * from student where sid = ?");
			pst.setString(1, sid);
			ResultSet rs = pst.executeQuery();
			boolean b = rs.next();
			if(b == true) {
				student = new Student();
				student.setSid(rs.getString("SID"));
				student.setSname(rs.getString("SNAME"));
				student.setSaddr(rs.getString("SADDR"));
			}
			else {
				student = null;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return student;
	}

	@Override
	public String update(Student student) {
		String status = "";
		try {
			Connection conn = oracleDataSource.getConnection();
			PreparedStatement pst = conn.prepareStatement("update student set SNAME = ?, SADDR = ? where SID = ?");
			pst.setString(1, student.getSname());
			pst.setString(2, student.getSaddr());
			pst.setString(3, student.getSid());
			
			int rowCount = pst.executeUpdate();
			if(rowCount == 1) {
				status = "success";
			}else {
				status="failure";
			}
			
		} catch (Exception e) {
			status = "failure";
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public String delete(String sid) {
		String status = "";
		try {
			Connection conn = oracleDataSource.getConnection();
			PreparedStatement pst = conn.prepareStatement("select * from student where SID = ?");
			pst.setString(1, sid);
			ResultSet rs = pst.executeQuery();
			boolean b= rs.next();
			if(b == true) {
				pst = conn.prepareStatement("delete from student where SID = ?");
				pst.setString(1, sid);
				int rowCount = pst.executeUpdate();
				if(rowCount == 1) {
					status = "success";
				}else {
					status = "failure";
				}
			}else {
				status = "notexisted";
			}
		} catch (Exception e) {
			status="failure";
			e.printStackTrace();
		}
		return status;
	}

}
