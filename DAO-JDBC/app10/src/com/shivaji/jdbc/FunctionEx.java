/*
create or replace function getAVG(no1 IN number, no2 IN number)return FLOAT
AS
	sal1 float;
	sal2 float;
BEGIN
	select ESAL into sal1 from emp1 where ENO = no1;
	select ESAL into sal2 from emp1 where ENO = no2;
	return (sal1+sal2)/2;
END getAVG;
/
 */
package com.shivaji.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class FunctionEx {

	public static void main(String[] args)throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","durga");
		CallableStatement cst = conn.prepareCall("{? = call getAVG(?,?)}");
		cst.setInt(2, 222);
		cst.setInt(3, 333);
		cst.registerOutParameter(1, Types.FLOAT);
		cst.execute();
		System.out.println("Average Salary  : "+cst.getFloat(1));
		cst.close();
		conn.close();
	}

}
