package com.bxa.service;

import java.util.Set;

import com.bxa.model.User;

public interface UserService {
	public User createUser(User user);
	public User updateUser(User user);
	public User getUser(long id);
	public boolean deleteUser(User user);
	public Set<User> getUserList();
}
