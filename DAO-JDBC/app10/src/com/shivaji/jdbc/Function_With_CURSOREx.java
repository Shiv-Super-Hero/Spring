/*
create or replace function getEmployees(sal_Range IN float)return SYS_REFCURSOR
as
employees SYS_REFCURSOR;
BEGIN
	open employees for select * from emp1 where ESAL < sal_Range;
	return employees;
END getEmployees;
/
 */
package com.shivaji.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import oracle.jdbc.OracleTypes;

public class Function_With_CURSOREx {

	public static void main(String[] args) throws Exception{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","durga");
		CallableStatement cst = conn.prepareCall("{? = call getEmployees(?)}");
		cst.setFloat(2, 3600);
		cst.registerOutParameter(1, OracleTypes.CURSOR);
		cst.execute();
		ResultSet rs = (ResultSet)cst.getObject(1);
		System.out.println("ENO\tENAME\tESAL\tEADDR");
		System.out.println("--------------------------");
		while (rs.next()) {
			System.out.print(rs.getInt("ENO")+"\t");
			System.out.print(rs.getString("ENAME")+"\t");
			System.out.print(rs.getFloat("ESAL")+"\t");
			System.out.print(rs.getString("EADDR")+"\n");
		}
		rs.close();
		cst.close();
		conn.close();
	}
}
