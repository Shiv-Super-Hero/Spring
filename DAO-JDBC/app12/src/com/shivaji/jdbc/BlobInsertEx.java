package com.shivaji.jdbc;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class BlobInsertEx {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pst = null;
		FileInputStream fis = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","durga");
			pst = conn.prepareStatement("insert into emp10 values(?,?)");
			pst.setInt(1, 111);
			
			File file = new File("C:\\Users\\Shiv Narayan Singh\\OneDrive\\Pictures\\Screenshots\\Shiv_Narayan.png");
			fis = new FileInputStream(file);
			pst.setBinaryStream(2, fis, (int)file.length());
			
			int rowCount = pst.executeUpdate();
			if(rowCount == 1) {
				System.out.println("Employee 111 Inserted Successfully!");
			}else {
				System.out.println("Employee 111 Insertion Failure!");
			}
			
		} catch (Exception e) {
			System.out.println("Employee Insertion Failure");
			e.printStackTrace();
		}finally {
			try {
				fis.close();
				pst.close();
				conn.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
	}

}
