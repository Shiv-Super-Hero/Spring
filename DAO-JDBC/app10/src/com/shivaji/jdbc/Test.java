/*
create or replace procedure getSal(no IN number, sal OUT float)
AS
BEGIN
	select esal into sal from emp1 where ENO = no;
END getSal;
/
*/
package com.shivaji.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class Test {

	public static void main(String[] args) throws Exception{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","durga");
		CallableStatement cst = conn.prepareCall("{call getSal(?,?)}");
		cst.setInt(1, 222);
		cst.registerOutParameter(2, Types.FLOAT);
		cst.execute();
		System.out.println("Salary   : "+cst.getFloat(2));
		cst.close();
		conn.close();
	}

}
