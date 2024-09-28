package com.orm;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.orm.entities.Employee;
import com.orm.util.HibernatePropUtil;
import com.orm.util.HibernateJ2EEUtil;
import com.orm.util.HibernateJ2SEUtil;

public class HibernateTest {

	public static void main(String[] args) {
		SessionFactory sf = HibernateJ2EEUtil.getSF();
		Session session = sf.openSession();
		List<Employee> emps = session.createSelectionQuery("from Employee", Employee.class).getResultList();
		System.out.println(emps.size());
		session.close();

		sf = HibernatePropUtil.getSF();
		session = sf.openSession();
		emps = session.createSelectionQuery("from Employee", Employee.class).getResultList();
		session.close();
		System.out.println(emps.size());


		sf = HibernatePropUtil.getSf();
		session = sf.openSession();
		emps = session.createSelectionQuery("from Employee", Employee.class).getResultList();
		session.close();
		System.out.println(emps.size());

		sf = HibernateJ2SEUtil.getSF();
		session = sf.openSession();
		emps = session.createSelectionQuery("from Employee", Employee.class).getResultList();
		session.close();
		System.out.println(emps.size());
	}
}
