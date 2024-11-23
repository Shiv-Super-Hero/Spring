package com.shivaji.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcApp {
	Connection conn = null;
	Statement st = null;
	ResultSet rs = null;
	
	public JdbcApp() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/durgadb","root","durga");
			st = conn.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void getEmpDetails() {
		try {
			rs = st.executeQuery("select * from emp1");
			System.out.println("ENO\tENAME\tESAL\tEADDR");
			System.out.println("----------------------------");
			while(rs.next()) {
				System.out.print(rs.getInt("ENO")+"\t");
				System.out.print(rs.getString("ENAME")+"\t");
				System.out.print(rs.getFloat("ESAL")+"\t");
				System.out.print(rs.getString("EADDR")+"\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				st.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
