package com.bxa.test.data;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.bxa.model.Role;
import com.bxa.model.User;

public class TestDataStore {
	private static Set<User> users = new HashSet<User>();
	private static Set<Role> roles = new HashSet<Role>();
	
	static User admin_user = new User(1, "admin_user", new HashSet<Role>(Arrays.asList(Role.employee,Role.admin)), "admin_user");
	static User manager_user = new User(2, "manager_user", new HashSet<Role>(Arrays.asList(Role.employee,Role.manager)), "manager_user");
	static User employee_user = new User(3, "employee_user", new HashSet<Role>(Arrays.asList(Role.employee)), "employee_user");
	
	static{
		roles.add(Role.admin);
		roles.add(Role.manager);
		roles.add(Role.employee);
		
		users.add(admin_user);
		users.add(manager_user);
		users.add(employee_user);
	}
	
	public static Set<User> getUsers(){
		return users;
	}
	
	public static Set<Role> getRoles(){
		return roles;
	}
	
	public static User getUser(long id){
		if(id==1)
			return admin_user;
		if(id==2)
			return manager_user;
		if(id==3)
			return employee_user;
		else
			return null;
	}
	
	public static User getUserByUserName(String username){
		if(username.equals("admin_user"))
			return admin_user ;
		if(username.equals("manager_user"))
			return manager_user;
		if(username.equals("employee_user"))
			return employee_user;
		else
			return null;
	}
	
	public static Role getRole(long id){
		if(id==1)
			return Role.admin;
		if(id==2)
			return Role.manager;
		if(id==3)
			return Role.employee;
		else
			return null;
	}
}
