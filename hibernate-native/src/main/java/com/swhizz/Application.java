package com.swhizz;

import com.swhizz.dao.EmployeeDao;
import com.swhizz.dao.EmployeeDaoImpl;
import com.swhizz.entity.Employee;

public class Application {

	public static void main(String[] args) {
		EmployeeDao dao = new EmployeeDaoImpl();

		Employee em1 = new Employee("Ram");
		Employee em2 = new Employee("Ram");
		Employee em3 = new Employee("Ram");
		dao.save(em1);
		dao.save(em2);
		dao.save(em3);
		System.out.println("------------After Save-------------");
		for (Employee e : dao.findAll()) {
			System.out.println(e);
		}
		
		// Update
		Employee _em2 = new Employee(2, "Mohan");
		dao.update(_em2);
		System.out.println("------------After Update-------------");
		// By Id
		System.out.println(dao.findById(2));
		
		dao.delete(2);
		System.out.println("------------After Delete-------------");
		for (Employee e : dao.findAll()) {
			System.out.println(e);
		}
		
		System.out.println(dao.findByName("Ram"));
	}
}
