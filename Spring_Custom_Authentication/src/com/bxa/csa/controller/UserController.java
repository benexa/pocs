package com.bxa.csa.controller;


import java.beans.PropertyEditorSupport;
import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bxa.csa.model.CRole;
import com.bxa.csa.model.CUser;
import com.bxa.csa.service.RoleService;
import com.bxa.csa.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	@Autowired
	RoleService roleService;
	
	@InitBinder
	public void binder(WebDataBinder binder){
		binder.registerCustomEditor(Set.class, "listOfRoles", new CustomCollectionEditor(Set.class) {

            protected Object convertElement(Object element) {
                if (element != null) {
                    Integer id = Integer.parseInt(element.toString());
                    CRole benefit = roleService.getRoleById(id); // something that able to get benefit object
                    return benefit;

                }
                return null;
            }

        });
	}
	
	@RequestMapping("/form")
	public String getUserForm(ModelMap modelMap){
		
		Set<CRole> allRoles = roleService.getListOfRoles();
		Set<CRole> userRoles = new HashSet<CRole>(allRoles.size());
		CUser user = new CUser();
		modelMap.addAttribute("roleList", allRoles);
		modelMap.addAttribute("user", user);
		return "user_form";
	} 
	
	
	@RequestMapping("/create")
	public String createNewUser(@ModelAttribute("user") @Valid CUser cuser, BindingResult result, ModelMap modelMap){
		if(result.hasErrors()){
			System.out.println(result);
		}
		CUser user = userService.createUser(cuser);
		modelMap.addAttribute("user", user);
		return "user";
	}
	
	

}
