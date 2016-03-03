package com.test.dao.factory;

import com.test.dao.UserDao;
import com.test.dao.impl.UserDaoImpl;

public class UserDaoFactory {
	
	public static UserDao getInstance(Class clas){
		UserDao userdao = null;
		
		try {
			userdao = (UserDao)Class.forName(clas.getName()).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return userdao;
	}
}
