package com.shivaji.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class JdbcApp {

	public static void main(String[] args) throws Exception{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","durga");
		PreparedStatement pst = conn.prepareStatement("insert into emp1 values(?,?,?,?)");
		
		pst.setInt(1, 111);
		pst.setString(2, "AAA");
		pst.setFloat(3, 2000);
		pst.setString(4, "Hyd");
		pst.addBatch();
		
		pst.setInt(1, 222);
		pst.setString(2, "BBB");
		pst.setFloat(3, 2500);
		pst.setString(4, "Goa");
		pst.addBatch();
		
		pst.setInt(1, 333);
		pst.setString(2, "CCC");
		pst.setFloat(3, 3000);
		pst.setString(4, "Pune");
		pst.addBatch();
		
		pst.setInt(1, 444);
		pst.setString(2, "DDD");
		pst.setFloat(3, 3500);
		pst.setString(4, "Manali");
		pst.addBatch();
		
		int[] rowCount = pst.executeBatch();
		for(int rc : rowCount) {
			System.out.println(rc);
		}
		
		pst.close();
		conn.close();
	}

}
