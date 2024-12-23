package com.shivaji.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.AbstractLobCreatingPreparedStatementCallback;
import org.springframework.jdbc.core.support.AbstractLobStreamingResultSetExtractor;
import org.springframework.jdbc.support.lob.LobCreator;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.util.FileCopyUtils;

import com.shivaji.dto.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	private JdbcTemplate jdbcTemplate;
	private LobHandler lobHandler;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public LobHandler getLobHandler() {
		return lobHandler;
	}
	
	public void setLobHandler(LobHandler lobHandler) {
		this.lobHandler = lobHandler;
	}
	
	@Override
	public void insertEmployee(Employee emp) {
		String query = "insert into emp20 values(?,?,?,?)";
		jdbcTemplate.execute(query,new AbstractLobCreatingPreparedStatementCallback(lobHandler) {
			
			@Override
			protected void setValues(PreparedStatement pst, LobCreator lobCreator) throws SQLException, DataAccessException {
				try {
					pst.setInt(1, emp.getEno());
					pst.setString(2, emp.getEname());
					FileInputStream fis = new FileInputStream(emp.getEmp_Image());
					FileReader fr = new FileReader(emp.getEmp_Resume());
					lobCreator.setBlobAsBinaryStream(pst, 3, fis, (int)emp.getEmp_Image().length());
					lobCreator.setClobAsCharacterStream(pst, 4, fr, (int)emp.getEmp_Resume().length());
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@Override
	public Employee readEmployee(int eno) {
		Employee emp = new Employee();
		String query = "select * from emp20 where ENO = "+eno;
		jdbcTemplate.query(query,new AbstractLobStreamingResultSetExtractor<Object>() {
			@Override
			protected void streamData(ResultSet rs) throws SQLException, IOException, DataAccessException {
				emp.setEno(rs.getInt("ENO"));
				emp.setEname(rs.getString("ENAME"));
				
				File file1 = new File("C:/Users/Shiv Narayan Singh/OneDrive/Pictures/Slide Shows/my_image.jpg");
				FileOutputStream fos = new FileOutputStream(file1);
				FileCopyUtils.copy(lobHandler.getBlobAsBinaryStream(rs, 3), fos);
				emp.setEmp_Image(file1);
				
				File file2 = new File("D:/Softwares/Struts/ravi_resume.docx");
				FileWriter fw = new FileWriter(file2);
				FileCopyUtils.copy(lobHandler.getClobAsCharacterStream(rs, 4), fw);
				emp.setEmp_Resume(file2);
			} 
		});
		
		return emp;
	}

}
