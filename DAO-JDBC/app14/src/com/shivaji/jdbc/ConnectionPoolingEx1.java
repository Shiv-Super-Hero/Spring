package com.shivaji.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import oracle.jdbc.pool.OracleDataSource;

public class ConnectionPoolingEx1 {

	public static void main(String[] args) {
		OracleDataSource ds = null;
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			ds = new OracleDataSource();
			ds.setURL("jdbc:oracle:thin:@localhost:1521:xe");
			ds.setUser("system");
			ds.setPassword("durga");
			
			conn = ds.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery("select * from emp1");
			System.out.println("ENO\tENAME\tESAL\tEADDR");
			System.out.println("------------------------");
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
