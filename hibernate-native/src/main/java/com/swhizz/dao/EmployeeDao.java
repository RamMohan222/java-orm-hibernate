package com.swhizz.dao;

import java.util.List;

import com.swhizz.entity.Employee;

public interface EmployeeDao {

	public void save(Employee e);

	public void update(Employee e);

	public List<Employee> findAll();

	public Employee findById(int eId);

	public void delete(int eId);

	public List<Employee> findByName(String name);

}
