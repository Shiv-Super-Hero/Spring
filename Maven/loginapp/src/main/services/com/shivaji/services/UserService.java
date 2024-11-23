package com.shivaji.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserService {
	Connection conn;
	Statement st;
	ResultSet rs;
	
	public UserService() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","durga");
			st = conn.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public String checkLogin(String uname,String upwd) {
		String status = "";
		try {
			rs = st.executeQuery("select * from reg_Users where UNAME = '"+uname+"' and UPWD = '"+upwd+"'");
			boolean b = rs.next();
			if(b == true) {
				status = "success";
			}else {
				status = "failure";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return status;
	}
}
