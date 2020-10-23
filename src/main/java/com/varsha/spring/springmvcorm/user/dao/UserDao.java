package com.varsha.spring.springmvcorm.user.dao;

import java.util.List;

import com.varsha.spring.springmvcorm.user.model.User;

public interface UserDao {
	// all crud operations
	int create(User user);
	List<User> readAllUsers();
	User findUserById(Integer id);
}
