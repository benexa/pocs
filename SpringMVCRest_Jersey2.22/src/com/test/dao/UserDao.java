package com.test.dao;

import com.test.model.User;

public interface UserDao {
	public User save(User user);
	public User edit(User user);
	public User delete(User user);
	public User get(long id);
}
