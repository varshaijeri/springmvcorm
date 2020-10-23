package com.varsha.spring.springmvcorm.user.service;

import java.util.List;

import com.varsha.spring.springmvcorm.user.model.User;

public interface UserService {

	int save(User user);
	List<User> loadAll();
	User getUserId(Integer id);
}
