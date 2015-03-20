package com.xinov.academix.web.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xinov.academix.core.model.User;

@Controller
@RequestMapping("login")
public class LoginController {

	@RequestMapping(method=RequestMethod.GET)
	public void login(@ModelAttribute User user){
		user = new User();
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public void submitLogin(@ModelAttribute User user){
		System.out.println(user.getUserId());
	}
}
