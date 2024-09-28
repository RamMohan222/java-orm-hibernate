package com.swhizz;

import com.swhizz.dao.UserDaoImpl;
import com.swhizz.entity.UserEntity;

public class Main {

	public static void main(String[] args) {

		UserDaoImpl daoImpl = new UserDaoImpl();

		UserEntity user0 = new UserEntity();
		user0.setUsername("Ram");
		user0.setPassword("PassWord@123");

		daoImpl.save(user0);
		System.out.println("===After save===");
		for (UserEntity e : daoImpl.findAll()) {
			System.out.println(e);
		}
		
		UserEntity user1 = new UserEntity();
		user1.setId(2);
		user1.setUsername("Mohan");
		user1.setPassword("PassWord@123");
		daoImpl.update(user1);
		System.out.println("===After Update===");
		for (UserEntity e : daoImpl.findAll()) {
			System.out.println(e);
		}

		
		System.out.println("Find By ID: "+daoImpl.findById(1));
		
		daoImpl.delete(1);
		System.out.println("===After Delete===");
		for (UserEntity e : daoImpl.findAll()) {
			System.out.println(e);
		}
	}

}
