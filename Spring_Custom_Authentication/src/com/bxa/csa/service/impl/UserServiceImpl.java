package com.bxa.csa.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bxa.csa.dao.CUserDao;
import com.bxa.csa.model.CRole;
import com.bxa.csa.model.CUser;
import com.bxa.csa.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	CUserDao userDao;
	
	@Override
	public CUser createUser(CUser cuser) {
		return userDao.save(cuser);
	}

	@Override
	public CUser updateUser(CUser cuser) {
		return userDao.update(cuser);
	}

	@Override
	public CUser getUserById(long id) {
		return userDao.get(id);
	}

	@Override
	public boolean deleteUser(CUser cuser) {
		return userDao.delete(cuser);
	}

	@Override
	public Set<CUser> getListOfUsers() {
		return userDao.getAll();
	}

	@Override
	public Set<CRole> getUserRoles(long id) {
		return userDao.getUserRoles(id);
	}
	
	
}
