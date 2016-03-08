package com.bxa.csa.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bxa.csa.model.CUser;
import com.bxa.csa.service.UserService;

@Controller
@RequestMapping("/test")
public class TestDBConnection {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/dbcon")
	@ResponseBody()
	public String testDBCon(){
		Session session = sessionFactory.openSession();
		session.close();
		return session.toString();
	}
	
}
