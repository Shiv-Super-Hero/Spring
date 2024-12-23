package com.shivaji.jdbc;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BlobReadEx {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		InputStream is = null;
		FileOutputStream fos = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","durga");
			pst = conn.prepareStatement("select * from emp10 where ENO = ?");
			pst.setInt(1, 111);
			rs = pst.executeQuery();
			rs.next();
			System.out.println("Employee Number    : "+rs.getInt("ENO"));
			fos = new FileOutputStream("D:/FileHistory/shivaji.jpg");
			is = rs.getBinaryStream(2);
			
			int val = is.read();
			while(val != -1) {
				fos.write(val);
				val = is.read();
			}
			System.out.println("Image Data Retrieved from DataBase to D:/FileHistory/shivaji.jpg");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				is.close();
				fos.close();
				rs.close();
				pst.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
