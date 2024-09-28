package com.orm.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.schema.Action;

import com.orm.entities.Employee;

public class HibernatePropUtil {
	private HibernatePropUtil() {}

	private static final SessionFactory sessionFactory =
	        new Configuration()
	            .addAnnotatedClass(Employee.class)
	            // mysql
	            .setProperty(AvailableSettings.JAKARTA_JDBC_URL, "jdbc:mysql://localhost:3306/testdb")
	            // Credentials
	            .setProperty(AvailableSettings.JAKARTA_JDBC_USER, "root")
	            .setProperty(AvailableSettings.JAKARTA_JDBC_PASSWORD, "root")
	            // Automatic schema export
	            .setProperty(AvailableSettings.JAKARTA_HBM2DDL_DATABASE_ACTION, Action.ACTION_VALIDATE)
	            // .setProperty(AvailableSettings.JAKARTA_HBM2DDL_DATABASE_ACTION, Action.SPEC_ACTION_DROP_AND_CREATE)
	            // SQL statement logging
	            .setProperty(AvailableSettings.SHOW_SQL, true)
	            .setProperty(AvailableSettings.FORMAT_SQL, true)
	            .setProperty(AvailableSettings.HIGHLIGHT_SQL, true)
	            // Create a new SessionFactory
	            .buildSessionFactory();

	public static SessionFactory getSF() {
		return sessionFactory;
	}

	public static SessionFactory getSf() {
		Configuration configuration = new Configuration();
		//configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		// configuration.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
		configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/testdb");
		configuration.setProperty("hibernate.connection.username", "root");
		configuration.setProperty("hibernate.connection.password", "root");
		configuration.setProperty("hibernate.hbm2ddl.auto", "validate");
		configuration.setProperty("hibernate.show_sql", true);
		configuration.setProperty("hibernate.format_sql", true);
		configuration.setProperty("hibernate.highlight_sql", true);

		configuration.addAnnotatedClass(Employee.class);
		return configuration.buildSessionFactory();
	}
}
