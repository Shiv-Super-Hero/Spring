package com.shivaji.service;

import com.shivaji.beans.Employee;

public class EmployeeServiceImpl implements EmployeeService {

	@Override
	public String createEmployee(Employee emp) throws Exception {
		System.out.println("Employee "+emp.getEno()+" Inserted Successfully from createEmployee() method.");
		int i=100;
		int j=0;
		float f = i/j;
		return "Success";
	}

	@Override
	public Employee searchEmployee(int eno) {
		System.out.println("Employee "+eno+" Existed from searchEmployee() method.");
		
		return null;
	}

	@Override
	public String updateEmployee(Employee emp) {
		System.out.println("Employee "+emp.getEno()+" Updated Successfully from updateEmployee() method.");
		return "Success";
	}

	@Override
	public String deleteEmployee(Employee emp) {
		System.out.println("Employee "+emp.getEno()+" Deleted Successfully from deleteEmployee() method.");
		return "Success";
	}

}
