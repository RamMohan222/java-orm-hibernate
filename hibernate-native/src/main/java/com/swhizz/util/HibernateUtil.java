package com.swhizz.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sf = setUp();

	private static SessionFactory setUp() {
		Configuration config = new Configuration();
		config.configure();
		// if not from hibernate.cfg.xml
		// config.addAnnotatedClass(Employee.class);
		return config.buildSessionFactory();
	}

	public static Session getSession() {
		return sf.openSession();
	}
}
