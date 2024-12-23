package com.shivaji.dao;

import java.util.List;

import org.springframework.jdbc.core.support.JdbcDaoSupport;


import com.shivaji.dto.Employee;

public class EmployeeDaoImpl extends JdbcDaoSupport implements EmployeeDao {

	@Override
	public String add(Employee emp) {
		String status = "";
		try {
			Employee emp1 = search(emp.getEno());
			if(emp1 == null) {
				int rowCount = getJdbcTemplate().update("insert into emp1 values(?,?,?,?)",emp.getEno(),emp.getEname(),emp.getEsal(),emp.getEaddr());
				if(rowCount == 1) {
					status = "Employee Inserted Successfully";
				}else {
					status = "Employee Insertion Failure";
				}	
			}else {
				status = "Employee Existed Already";
			}
		} catch (Exception e) {
			status = "Employee Insertion Failure";
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public Employee search(int eno) {
		Employee emp = null;
		try {
			String query = "select * from emp1 where ENO = ?";
			List<Employee> empsList = getJdbcTemplate().query(query, new Object[] {eno},(rs,index) -> {
				Employee emp1 = new Employee();
				emp1.setEno(rs.getInt("ENO"));
				emp1.setEname(rs.getString("ENAME"));
				emp1.setEsal(rs.getFloat("ESAL"));
				emp1.setEaddr(rs.getString("EADDR"));
				return emp1;
			});
			if(empsList.isEmpty() == true) {
				emp = null;
			}
			else {
				emp = empsList.get(0);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emp;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> empsList = null;
		try {
			empsList = getJdbcTemplate().query("select * from emp1", (rs,index) -> {
				Employee emp = new Employee();
				emp.setEno(rs.getInt("ENO"));
				emp.setEname(rs.getString("ENAME"));
				emp.setEsal(rs.getFloat("ESAL"));
				emp.setEaddr(rs.getString("EADDR"));
				return emp;
			});
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return empsList;
	}

	@Override
	public String update(Employee emp) {
		String status = "";
		try {
			Employee emp1 = search(emp.getEno());
			if(emp1 == null) {
				status = "Employee Not Existed";
			}else {
				String query = "update emp1 set ENAME = ?, ESAL = ?, EADDR = ? where ENO = ?";
				int rowCount = getJdbcTemplate().update(query,emp.getEname(),emp.getEsal(),emp.getEaddr(),emp.getEno());
				if(rowCount == 1) {
					System.out.println("Employee Updation Successful");
				}else {
					System.out.println("Employee Updation Failure");
				}
			}
		} catch (Exception e) {
			System.out.println("Employee Updation Phailure.");
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
				status = "Employee Not Existed";
			}else {
				int rowCount = getJdbcTemplate().update("delete from emp1 where ENO = ?", eno);
				if(rowCount == 1) {
					status = "Employee Deletion Successful";
				}else {
					status = "Employee Deletion Failure";
				}
			}
		} catch (Exception e) {
			status = "Employee Deletion Phailure";
			e.printStackTrace();
		}
		return status;
	}

}
