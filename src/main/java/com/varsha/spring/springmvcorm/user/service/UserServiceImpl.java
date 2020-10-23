package com.varsha.spring.springmvcorm.user.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.varsha.spring.springmvcorm.user.dao.UserDao;
import com.varsha.spring.springmvcorm.user.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	@Transactional
	public int save(User user) {
		//business logic
		return userDao.create(user);
	}

	@Override
	public List<User> loadAll() {
		List<User> users = userDao.readAllUsers();
		Collections.sort(users);
		return users;
	}

	@Override
	public User getUserId(Integer id) {
		return userDao.findUserById(id);
	}
}
