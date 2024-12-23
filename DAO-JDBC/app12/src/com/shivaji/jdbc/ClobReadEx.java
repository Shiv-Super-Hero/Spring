package com.shivaji.jdbc;

import java.io.FileWriter;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ClobReadEx {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		FileWriter fw = null;
		Reader r = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","durga");
			pst = conn.prepareStatement("select * from appps where APP_NAME = ?");
			pst.setString(1, "app01");
			rs = pst.executeQuery();
			rs.next();
			System.out.println("Application Name    : "+rs.getString(1));
			r = rs.getCharacterStream(2);
			fw = new FileWriter("D:\\Softwares\\Struts\\Spring_XSDs.txt");
			int val = r.read();
			while(val != -1) {
				fw.write(val);
				val = r.read();
			}
			System.out.println("CLOB data retrieved from DB to D:\\Softwares\\Struts\\Spring_XSDs.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				r.close();
				fw.close();
				rs.close();
				pst.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
