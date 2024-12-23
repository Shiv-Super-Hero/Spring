package com.shivaji.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.shivaji.entity.Employee;

public class ClientApp {
	public void insert() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			
			Configuration cfg = new Configuration();
			//cfg.configure("/hibernate.cfg.xml");
			cfg.configure("hibernate.cfg.xml");
			//cfg.configure("/com/shivaji/resources/hibernate.cfg.xml");
			sessionFactory = cfg.buildSessionFactory();
			session = sessionFactory.openSession();
			Employee emp = new Employee();
			emp.setEno(111);
			emp.setEname("AAA");
			emp.setEsal(2000);
			emp.setEaddr("Hyd");
			tx = session.beginTransaction();
			session.save(emp);
			tx.commit();
			System.out.println("Employee Inserted Successfully");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				session.close();
				sessionFactory.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
