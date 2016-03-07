package com.bxa.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.bxa.dao.UserDao;
import com.bxa.model.User;
import com.bxa.service.UserService;

public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUser(long id) {
		// TODO Auto-generated method stub
		return userDao.get(id);
	}

	@Override
	public boolean deleteUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<User> getUserList() {
		// TODO Auto-generated method stub
		return userDao.getAll();
	}
	
	

}
