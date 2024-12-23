package com.shivaji.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.shivaji.dto.Employee;
import com.shivaji.mapper.EmployeeRowMapper;

public class EmployeeDaoImpl implements EmployeeDao {
	private JdbcTemplate JdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		JdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public String add(Employee emp) {
		String status = "";
		try {
			List<Employee> empList = JdbcTemplate.query("select * from emp1 where ENO = ?",new Object[] {emp.getEno()}, (rs,index)->{
				Employee emp1 = new Employee();
				emp1.setEno(rs.getInt("ENO"));
				emp1.setEname(rs.getString("ENAME"));
				emp.setEsal(rs.getFloat("ESAL"));
				emp.setEaddr(rs.getString("EADDR"));
				return emp1;
			});
			if(empList.isEmpty() == true) {
				int rowCount = JdbcTemplate.update("insert into emp1 values(?,?,?,?)",new Object[] {emp.getEno(),emp.getEname(),emp.getEsal(),emp.getEaddr()});
				if(rowCount == 1) {
					status = "Employee Inserted Successfully.";
				}else {
					status="Employee Insertion Failure.";
				}
			}else {
				status = "Employee Existed Already.";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public Employee search(int eno) {
		Employee emp = null;
		try {
			List<Employee> empList = JdbcTemplate.query("select * from emp1 where ENO = ?",new Object[] {eno},(rs,index)->{
				Employee emp1 = new Employee();
				emp1.setEno(rs.getInt("ENO"));
				emp1.setEname(rs.getString("ENAME"));
				emp1.setEsal(rs.getFloat("ESAL"));
				emp1.setEaddr(rs.getString("EADDR"));
				return emp1;
			});
			if(empList.isEmpty()) {
				emp = null;
			}else {
				emp = empList.get(0);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emp;
	}

	@Override
	public String update(Employee emp) {
		String status = "";
		try {
			Employee emp1 = search(emp.getEno());
			if(emp1 == null) {
				status = "Employee Not Existed.";
			}else {
				int rowCount = JdbcTemplate.update("update emp1 set ENAME = ?,ESAL = ?,EADDR = ? where ENO = ?",new Object[] {emp.getEname(),emp.getEsal(),emp.getEaddr(),emp.getEno()});
				if(rowCount == 1) {
					System.out.println("Employee Updated Successfully");
				}else {
					System.out.println("Employee Updation Failure");
				}	
			}
		} catch (Exception e) {
			status = "Employee Updation Failure";
			e.printStackTrace();
		}
		return status;
	}
	@Override
	public String delete(int eno) {
		String status = "";
		try {
			Employee emp = search(eno);
			if(emp == null) {
				status = "Employee Not Existed!";
			}else {
				int rowCount = JdbcTemplate.update("delete from emp1 where ENO = ?",new Object[] {eno});
				if(rowCount == 1) {
					status = "Employee Deleted Successfully!";
				}else {
					status = "Employee Deletion Failure!";
				}
			}
		} catch (Exception e) {
			status = "Employee Deletion failure";
			e.printStackTrace();
		}
		return status;
	}

}
