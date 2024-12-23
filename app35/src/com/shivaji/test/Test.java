package com.shivaji.test;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import com.shivaji.beans.Employee;

public class Test {

	public static void main(String[] args) {
		BeanWrapper bw = new BeanWrapperImpl(Employee.class);
		bw.setPropertyValue("eno",111);
		bw.setPropertyValue("ename","AAA");
		bw.setPropertyValue("esal",5000);
		bw.setPropertyValue("eaddr","Hyd");
		System.out.println("-----------------------");
		System.out.println("Employee Number    : "+bw.getPropertyValue("eno"));
		System.out.println("Employee Name      : "+bw.getPropertyValue("ename"));
		System.out.println("Employee Salary    : "+bw.getPropertyValue("esal"));
		System.out.println("Employee Address   : "+bw.getPropertyValue("eaddr"));
		
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("eno",222);
		map.put("ename","BBB");
		map.put("esal",5000);
		map.put("eaddr","Hyd");
		bw.setPropertyValues(map);
		
		Employee emp = (Employee)bw.getWrappedInstance();
		emp.getEmployeeDetails();
		System.out.println();
		
		System.out.println(bw.isReadableProperty("eno"));
		System.out.println(bw.isReadableProperty("eame"));
		System.out.println(bw.isReadableProperty("esal"));
		System.out.println(bw.isReadableProperty("eaddr"));
		
		System.out.println();
		
		System.out.println(bw.isWritableProperty("eno"));
		System.out.println(bw.isWritableProperty("ename"));
		System.out.println(bw.isWritableProperty("esal"));
		System.out.println(bw.isWritableProperty("eaddr"));
		System.out.println();
		
		Employee emp1 = new Employee();
		BeanUtils.copyProperties(emp, emp1);
		emp1.getEmployeeDetails();
	}

}
