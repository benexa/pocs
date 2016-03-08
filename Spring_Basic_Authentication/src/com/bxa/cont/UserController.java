package com.bxa.cont;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bxa.service.UserService;

@Controller
@RequestMapping("/")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping
	public String getUserList(Model model){
		model.addAttribute("userList", userService.getUserList());
		return "userList";
	}
}
