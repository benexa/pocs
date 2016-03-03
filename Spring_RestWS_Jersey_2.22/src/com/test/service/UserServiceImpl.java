package com.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.dao.UserDao;
import com.test.dao.factory.UserDaoFactory;
import com.test.dao.impl.UserDaoCustomImpl;
import com.test.dao.impl.UserDaoImpl;
import com.test.dao.impl.UserDaoThirdImpl;
import com.test.model.User;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Component
@Path("/UserService")
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;// = UserDaoFactory.getInstance(UserDaoThirdImpl.class);
	
	@Override
	public User createUser(User user) {
		userDao.save(user);
		return user;
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User editUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUser(long id) {
		// TODO Auto-generated method stub
		User user = new User(1, "one");
		return user;
	}
	
	@GET
	@Path("/user")
	@Produces(MediaType.APPLICATION_XML)
	public User getUserInfo() {
		// TODO Auto-generated method stub
		return userDao.get(1);
	}

}
