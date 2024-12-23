package com.shivaji.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

import com.shivaji.dto.Employee;

public class EmployeeDaoImpl extends NamedParameterJdbcDaoSupport implements EmployeeDao {

	private DataSource ds;//Should't be dataSource
	public void setDs(DataSource dataSource) {
		setDataSource(dataSource);
	}
	@Override
	public String add(Employee emp) {
		String status = "";
		try {
			Employee emp1 = search(emp.getEno());
			if(emp1 == null) {
				String query = "insert into emp1 values(:eno,:ename,:esal,:eaddr)";
				Map<String, Object> params = new HashMap<String,Object>();
				params.put("eno", emp.getEno());
				params.put("ename",emp.getEname());
				params.put("esal", emp.getEsal());
				params.put("saddr", emp.getEaddr());
				
				int rowCount = getNamedParameterJdbcTemplate().update(query,params);
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
			String query = "select * from emp1 where ENO = :eno";
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("eno", eno);
			List<Employee> empsList = getNamedParameterJdbcTemplate().query(query, params,(rs,index) -> {
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
			empsList = getNamedParameterJdbcTemplate().query("select * from emp1", (rs,index) -> {
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
				String query = "update emp1 set ENAME = :ename, ESAL = :esal, EADDR = :eaddr where ENO = :eno";
				Map<String,Object> params = new HashMap<String,Object>();
				params.put("ename", emp.getEname());
				params.put("esal", emp.getEsal());
				params.put("eaddr", emp.getEaddr());
				params.put("eno", emp.getEno());
				int rowCount = getNamedParameterJdbcTemplate().update(query,params);
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
				String query = "delete from emp1 where ENO = :eno";
				Map<String, Object> params = new HashMap<String, Object>();
				params.put("eno", eno);
				int rowCount = getNamedParameterJdbcTemplate().update(query,params);
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
