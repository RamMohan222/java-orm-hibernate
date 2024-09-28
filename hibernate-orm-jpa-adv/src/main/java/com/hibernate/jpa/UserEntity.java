package com.hibernate.jpa;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Cacheable(true)
@Entity
@Table(name = "user")
public class UserEntity {

	@Id
	@Column(name = "pk_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String name;
	private String mobileNo;

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

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", name=" + name + ", mobileNo=" + mobileNo + "]";
	}

}
