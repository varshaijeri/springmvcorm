package com.varsha.spring.springmvcorm.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.varsha.spring.springmvcorm.user.model.User;
import com.varsha.spring.springmvcorm.user.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping("register")
	public String showRegister() {
		return "userReg";
	}
	
	@RequestMapping(value = "registerUser", method=RequestMethod.POST)
	public String getRegisteredUser(@ModelAttribute("user") User user,ModelMap model) {
		int result = userService.save(user);
		model.addAttribute("result", "Registered user with ID: "+result);
		return "userReg";
	}
	
	@RequestMapping("getUsers")
	public String getUsers(ModelMap model) {
		List<User> userList = userService.loadAll();
		model.addAttribute("userList", userList);
		return "displayUsers";
	}
	
	@RequestMapping("validateEmail")
	public @ResponseBody String validateEmail(@RequestParam("id") int id) {
		User user = userService.getUserId(id);
		String msg="";
		if(user!=null) {
			//user already exists
			msg=id+" user already exists with email: "+user.getEmail();
		}
		return msg;
	}
}
