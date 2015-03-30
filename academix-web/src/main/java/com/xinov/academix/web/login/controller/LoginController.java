package com.xinov.academix.web.login.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.xinov.academix.core.api.model.User;
import com.xinov.academix.web.user.service.UserService;

@Controller
@RequestMapping("login")
@SessionAttributes(value={"user"})
public class LoginController {
	
	private @Autowired UserService userService;

	@ModelAttribute("user")
	public User populateForm() {
		return new User(); // populates form for the first time if its null
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public void login(@ModelAttribute("user") User user){
		user = new User();
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String submitLogin(@ModelAttribute("user") User user, HttpSession session){
		user = userService.get(user.getUserId(), user.getPassword());
		if(user != null){
			session.setAttribute("user", user);
			return "home";
		}else{
			return "login";
		}
	}
}
