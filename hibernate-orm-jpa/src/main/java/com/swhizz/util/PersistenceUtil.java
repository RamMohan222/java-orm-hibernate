package com.swhizz.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceUtil {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-unit");
	public static EntityManager em() {
		return emf.createEntityManager();
	}
}
