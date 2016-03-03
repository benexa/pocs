package com.bxa.dao;

import java.util.Set;

import com.bxa.model.User;

public interface UserDao {
	public User save(User user);
	public User update(User user);
	public User delete(User user);
	public User get(long id);
	public Set<User> getAll();
}
