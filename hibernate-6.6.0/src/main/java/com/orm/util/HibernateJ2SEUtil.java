package com.orm.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.orm.entities.Employee;

/**
 * Good for stand alone applications
 */
public class HibernateJ2SEUtil {
	private HibernateJ2SEUtil() {}
	static final SessionFactory sessionFactory = new Configuration()
			.configure() // loads from hibernate.cfg.xml
			//.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Employee.class)
			.buildSessionFactory();

	public static SessionFactory getSF() {
		return sessionFactory;
	}
}
