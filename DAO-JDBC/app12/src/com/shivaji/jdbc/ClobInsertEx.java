package com.shivaji.jdbc;

import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ClobInsertEx {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pst = null;
		FileReader fr = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","durga");
			pst = conn.prepareStatement("insert into appps values(?,?)");
			pst.setString(1, "app01");
			
			File f = new File("D:/Softwares/Spring/xsd codes.txt");
			fr = new FileReader(f);
			pst.setCharacterStream(2, fr,f.length());
			int rowCount = pst.executeUpdate();
			if(rowCount == 1) {
				System.out.println("Document Insertion Successful!");
			}else {
				System.out.println("Document Insertion Failure");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				fr.close();
				pst.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
