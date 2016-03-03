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
	
	static Role admin = new Role(1,"admin","Admin Role has access to everything");
	static Role manager = new Role(2,"manager","Manager Role has access to self and employees");
	static Role employee = new Role(3,"employee","Employee Role has access to self only");
	
	
	static User user1 = new User(1, "admin_user", new HashSet<Role>(Arrays.asList(employee,admin)), "password_admin");
	static User user2 = new User(2, "manager_user", new HashSet<Role>(Arrays.asList(employee,manager)), "password_manager");
	static User user3 = new User(3, "employee_user", new HashSet<Role>(Arrays.asList(employee)), "password_employee");
	
	static{
		roles.add(admin);
		roles.add(manager);
		roles.add(employee);
		
		users.add(user1);
		users.add(user2);
		users.add(user3);
	}
	
	public static Set<User> getUsers(){
		return users;
	}
	
	public static Set<Role> getRoles(){
		return roles;
	}
	
	public static User getUser(long id){
		if(id==1)
			return user1;
		if(id==2)
			return user2;
		if(id==3)
			return user3;
		else
			return null;
	}
	
	public static Role getRole(long id){
		if(id==1)
			return admin;
		if(id==2)
			return manager;
		if(id==3)
			return employee;
		else
			return null;
	}
}
