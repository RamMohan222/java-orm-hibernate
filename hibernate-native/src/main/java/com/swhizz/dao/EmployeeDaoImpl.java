package com.swhizz.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.swhizz.entity.Employee;
import com.swhizz.util.HibernateUtil;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public void save(Employee emp) {
		Session session = HibernateUtil.getSession();
		Transaction tr = session.beginTransaction();
		try {
			session.save(emp);
			tr.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			tr.rollback();
		}
	}

	@Override
	public void update(Employee emp) {
		// should be in service layer
		if (emp.getId() <= 0) {
			throw new RuntimeException("Invalid employee ID");
		}

		Session session = HibernateUtil.getSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.merge(emp);
			tr.commit();
		} catch (Exception ex) {
			tr.rollback();
		}
	}

	@Override
	public List<Employee> findAll() {
		Session session = HibernateUtil.getSession();
		// select * from employee;
		// select u from Employee u;
		return session.createQuery("select u from Employee u", Employee.class).getResultList();
	}

	@Override
	public Employee findById(int eId) {
		Session session = HibernateUtil.getSession();
		// select * from employee;
		// select u from Employee u;
		return session.find(Employee.class, eId);
	}

	@Override
	public void delete(int eId) {
		Session session = HibernateUtil.getSession();
		Employee emp = session.find(Employee.class, eId);
		if (emp != null) {
			session.beginTransaction();
			try {
				session.delete(emp);
				session.getTransaction().commit();
			} catch (Exception e) {
				session.getTransaction().rollback();
			}
		}
	}

	@Override
	public List<Employee> findByName(String name) {
		Session session = HibernateUtil.getSession();
		Query<Employee> query = session.createQuery("select u from Employee u where u.name =:n", Employee.class);
		query.setParameter("n", name);
		return query.getResultList();
	}

}
