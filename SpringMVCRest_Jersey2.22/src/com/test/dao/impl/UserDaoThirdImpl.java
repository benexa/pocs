package com.test.dao.impl;

import com.test.dao.UserDao;
import com.test.model.User;

public class UserDaoThirdImpl implements UserDao {

	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User edit(User user) {
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
		User user = new User(1, "oone UserDaoThirdImpl");
		return user;
	}

}
