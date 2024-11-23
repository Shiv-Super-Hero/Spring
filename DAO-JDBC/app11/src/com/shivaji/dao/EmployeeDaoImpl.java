package com.shivaji.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;


import com.shivaji.dto.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	private DataSource dataSource;
	private SimpleJdbcCall simpleJdbcCall;
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		simpleJdbcCall = new SimpleJdbcCall(dataSource);
	}
	
	@Override
	public void create(Employee emp) {
		try {
			simpleJdbcCall = simpleJdbcCall.withProcedureName("insertEmployee");
			//SqlParameterSource params = new BeanPropertySqlParameterSource(emp);
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("no", emp.getEno());
			params.put("name", emp.getEname());
			params.put("sal", emp.getEsal());
			params.put("addr", emp.getEaddr());
			
			simpleJdbcCall.execute(params);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public Object getEmpSal(int eno) {
		Object sal = null;
		try {
			simpleJdbcCall = simpleJdbcCall.withProcedureName("getSal");
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("no", eno);
			Map<String, Object> out_Values = simpleJdbcCall.execute(params);
			sal = out_Values.get("SAL");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sal;
	}
	
	@Override
	public Employee getEmployee(int eno) {
		Employee emp = null;
		try {
			simpleJdbcCall = simpleJdbcCall.withProcedureName("getEmployee");
			simpleJdbcCall = simpleJdbcCall.returningResultSet("employee", BeanPropertyRowMapper.newInstance(Employee.class));
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("no", eno);
			Map<String, Object> out_Values = simpleJdbcCall.execute(params);
			ArrayList<Employee> list = (ArrayList<Employee>)out_Values.get("employee");
			emp = list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return emp;
	}
	
	@Override
	public void updateEmployee(Employee emp) {
		try {
			simpleJdbcCall = simpleJdbcCall.withProcedureName("updateEmployee");
			//SqlParameterSource in_Params = new BeanPropertySqlParameterSource(emp);
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("no", emp.getEno());
			params.put("name",emp.getEname());
			params.put("sal",emp.getEsal());
			params.put("addr", emp.getEaddr());
			simpleJdbcCall.execute(params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void deleteEmployee(int eno) {
		try {
			simpleJdbcCall = simpleJdbcCall.withProcedureName("deleteEmployee");
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("no", eno);
			simpleJdbcCall.execute(params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> all_Emps = null;
		try {
			simpleJdbcCall = simpleJdbcCall.withProcedureName("getAllEmployees");
			simpleJdbcCall = simpleJdbcCall.returningResultSet("employees", BeanPropertyRowMapper.newInstance(Employee.class));
			Map<String, Object> map = simpleJdbcCall.execute();
			all_Emps = (ArrayList<Employee>)map.get("employees");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return all_Emps;
	}

}
