package com.test.service;

import com.test.model.User;

public interface UserService {
	public User createUser(User user);
	public User updateUser(User user);
	public User editUser(User user);
	public User getUser(long id);
}
