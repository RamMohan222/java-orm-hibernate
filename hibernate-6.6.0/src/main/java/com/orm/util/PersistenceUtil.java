package com.orm.util;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public final class PersistenceUtil {
	private PersistenceUtil() {
	}

	private static final EntityManagerFactory emf = setUp();

	private static EntityManagerFactory setUp() {
		return Persistence.createEntityManagerFactory("jpa.orm.punit");
	}

	public static EntityManagerFactory getEmf() {
		return emf;
	}

}
