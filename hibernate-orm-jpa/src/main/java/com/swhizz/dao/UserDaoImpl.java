package com.swhizz.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.swhizz.entity.UserEntity;
import com.swhizz.util.PersistenceUtil;

public class UserDaoImpl implements UserDao {

	public void save(UserEntity user) {
		EntityManager em = PersistenceUtil.em();
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			// always creates a new record
			em.persist(user);
			et.commit();
		} catch (Exception e) {
			et.rollback();
		}
	}

	public void update(UserEntity user) {
		if (user.getId() == null || user.getId() <= 0)
			return;
		EntityManager em = PersistenceUtil.em();
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			// always creates a new record
			// em.persist(user);
			// if record found then updates it, if not creates new one
			em.merge(user); 
			et.commit();
		} catch (Exception e) {
			et.rollback();
		}
	}

	@Override
	public void delete(int userId) {
		EntityManager em = PersistenceUtil.em();
		// getReference() method throws exception if object not found
		// UserEntity user = em.getReference(UserEntity.class, userId);
		UserEntity user = em.find(UserEntity.class, userId);
		try {
			em.getTransaction().begin();
			if (user != null) {
				em.remove(user);
			}
			em.getTransaction().commit();
		} catch(Exception e) {
			em.getTransaction().rollback();
		}
	}

	@Override
	public List<UserEntity> findAll() {
		EntityManager em = PersistenceUtil.em();
		List<UserEntity> list = em.createQuery("from UserEntity", UserEntity.class).getResultList();
		return list;
	}

	@Override
	public UserEntity findById(int userId) {
		EntityManager em = PersistenceUtil.em();
		return em.find(UserEntity.class, userId);
	}
}
