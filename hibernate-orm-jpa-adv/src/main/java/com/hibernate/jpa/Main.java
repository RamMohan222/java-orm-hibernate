package com.hibernate.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
		EntityManager em = emf.createEntityManager();
		boolean is = em.isOpen();

		CriteriaQuery<UserEntity> query = em.getCriteriaBuilder()
				.createQuery(UserEntity.class); // it is final result type
		Root<UserEntity> root = query.from(UserEntity.class);
		query.select(root);
		query.where(em.getCriteriaBuilder().equal(root.get(UserEntity_.id), 1));

		List<UserEntity> users = em.createQuery(query).getResultList();
		users.forEach(System.out::println);
		System.out.println(is);
	}
}
