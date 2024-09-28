package com.swhizz.dao;

import java.util.List;

import com.swhizz.entity.UserEntity;

public interface UserDao {

	public void save(UserEntity user);

	public void update(UserEntity user);

	public UserEntity findById(int userId);

	public List<UserEntity> findAll();

	public void delete(int userId);
}
