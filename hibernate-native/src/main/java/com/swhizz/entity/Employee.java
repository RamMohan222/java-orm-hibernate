package com.swhizz.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table
public class Employee {

	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="bookSeq")  // reference to generator defined below
//	@SequenceGenerator(name="bookSeq", sequenceName="seq_book", initialValue = 1, allocationSize=10)
	
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="bookTbl")  // reference to generator defined below
	@TableGenerator(name="bookTbl", table = "book_id_table", initialValue = 3)
	private Integer id;

	private String name;

	public Employee() {
	}

	public Employee(String name) {
		this.name = name;
	}

	public Employee(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}

}
