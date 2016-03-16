package com.bxa.csa.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bxa.csa.dao.CUserDao;
import com.bxa.csa.model.CRole;
import com.bxa.csa.model.CUser;
import com.bxa.csa.security.acl.UserAclHandler;
import com.bxa.csa.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	CUserDao userDao;
	@Autowired
	UserAclHandler userAclHandler;
	
	@Override
	@Transactional
	public CUser createUser(CUser cuser) {
		userDao.save(cuser);
		userAclHandler.initializeDefaultAclPermissions(cuser);
		return cuser;
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

	@Override
	public CUser getUserByUsername(String username) {
		return userDao.getByUserName(username);
	}
		
}
