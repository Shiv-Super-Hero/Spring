package com.shivaji.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.shivaji.entity.Employee;

public class Test {

	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		
		try {
			Configuration cfg = new Configuration();
			cfg.configure("/com/shivaji/resources/hibernate.cfg.xml");
			sessionFactory = cfg.buildSessionFactory();
			session = sessionFactory.openSession();
			
			Employee emp = (Employee) session.get("com.shivaji.entity.Employee", 222);
			System.out.println("Employee Details");
			System.out.println("---------------------");
			System.out.println("Employee Number    : "+emp.getEno()); 
			System.out.println("Employee Name      : "+emp.getEname());
			System.out.println("Employee Salary    : "+emp.getEsal());
			System.out.println("Employee Address   : "+emp.getEaddr());
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				session.close();
				sessionFactory.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
