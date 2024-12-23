package com.shivaji.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.shivaji.entity.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	
	String status = "";

	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	@Override
	public String insertEmployee(Employee emp) {
		entityManager.persist(emp);
		status = "SUCCESS";
		return status;
	}

	@Override
	public Employee findEmployee(int eno) {
		Employee emp = (Employee)entityManager.find(Employee.class, eno);
		return emp;
	}

	@Transactional
	@Override
	public String updateEmployee(Employee emp) {
		Employee employee = (Employee)entityManager.find(Employee.class, emp.getEno());
		employee.setEname(emp.getEname());
		employee.setEsal(emp.getEsal());
		employee.setEaddr(emp.getEaddr());
		status = "SUCCESS";
		return status;
	}

	@Transactional
	@Override
	public String removeEmployee(int eno) {
		Employee employee = (Employee)entityManager.find(Employee.class,eno);
		entityManager.remove(employee);
		status = "SUCCESS";
		return status;
	}

}
