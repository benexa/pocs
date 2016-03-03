package com.bxa.dao.impl;

import java.util.Set;

import com.bxa.dao.UserDao;
import com.bxa.model.User;
import com.bxa.test.data.TestDataStore;

public class UserDaoImpl implements UserDao {

	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User update(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User delete(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User get(long id) {
		return TestDataStore.getUser(id);
	}

	@Override
	public Set<User> getAll() {
		// TODO Auto-generated method stub
		return TestDataStore.getUsers();
	}
	
}
