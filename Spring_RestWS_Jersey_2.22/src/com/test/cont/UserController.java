package com.test.cont;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.dao.UserDao;

@Controller
@RequestMapping("/suser")
public class UserController {
	
	@Autowired
	UserDao userDao;
	
	@RequestMapping("/sample")
	public String getSampleUser(ModelMap model){
		model.addAttribute("user",userDao.get(1));
		return "user";
	}
}
