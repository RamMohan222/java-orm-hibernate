package com.orm.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.orm.entities.Employee;

/**
 * 
 */
public final class HibernateJ2EEUtil {
	private HibernateJ2EEUtil() {}
	private static final SessionFactory sessionFactory = setUp();
	private static SessionFactory setUp() {
	    final StandardServiceRegistry registry =
	            new StandardServiceRegistryBuilder()
	                    .build();
	    try {
	        return new MetadataSources(registry)
	                        .addAnnotatedClass(Employee.class)
	                        .buildMetadata()
	                        .buildSessionFactory();
	    }
	    finally {
	        // The registry would be destroyed by the SessionFactory, but we
	        // had trouble building the SessionFactory so destroy it manually.
	        StandardServiceRegistryBuilder.destroy(registry);
	    }
	}
	public static SessionFactory getSF() {
		return sessionFactory;
	}
}
