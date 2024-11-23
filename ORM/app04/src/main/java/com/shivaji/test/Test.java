package com.shivaji.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.shivaji.entity.Employee;

public class Test {

	public static void main(String[] args) throws Exception{
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("emp");
		EntityManager entityManager = factory.createEntityManager();
		/*
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Employee emp = new Employee();
		emp.setEno(111);
		emp.setEname("AAA");
		emp.setEsal(2000);
		emp.setEaddr("Hyd");
		entityManager.persist(emp);
		entityTransaction.commit();
		System.out.println("Employee Inserted Successfully");
		entityManager.close();
		*/
		/*
		Employee emp = entityManager.find(Employee.class, 111);
		System.out.println("Employee Details");
		System.out.println("----------------------");
		System.out.println("Employee Number     : "+emp.getEno());
		System.out.println("Employee Name       : "+emp.getEname());
		System.out.println("Employee Salary     : "+emp.getEsal());
		System.out.println("Employee Address    : "+emp.getEaddr());
		entityManager.close();
		*/
		/*
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Employee emp = entityManager.find(Employee.class, 111);
		emp.setEname("BBB");
		emp.setEsal(3000);
		emp.setEaddr("Goa");
		entityTransaction.commit();
		System.out.println("Employee Updated Successfully");
		entityManager.close();
		*/
		
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Employee emp = entityManager.find(Employee.class, 111);
		entityManager.remove(emp);
		entityTransaction.commit();
		System.out.println("Employee Deleted Successfully");
		entityManager.close();
	}

}
