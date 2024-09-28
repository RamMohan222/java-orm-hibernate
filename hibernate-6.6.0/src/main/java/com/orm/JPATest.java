package com.orm;

import java.util.List;

import com.orm.entities.Employee;
import com.orm.util.PersistenceUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class JPATest {

	public static void main(String[] args) {
		EntityManagerFactory emf = PersistenceUtil.getEmf();
		EntityManager em = emf.createEntityManager();
		List<Employee> emps = em.createQuery("from Employee", Employee.class).getResultList();
		emps.forEach(e -> System.out.println(e.getName()));
		em.close();
	}
}
