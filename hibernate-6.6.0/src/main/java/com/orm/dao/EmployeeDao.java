package com.orm.dao;

import java.util.List;

import com.orm.entities.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;

public class EmployeeDao {
	@PersistenceUnit(unitName = "jpa.orm.punit")
	private EntityManagerFactory entityManagerFactory;

	public List<Employee> findAll() {
		try (EntityManager em = entityManagerFactory.createEntityManager()) {
			return em.createQuery("from Employee", Employee.class).getResultList();
		}
	}
}
