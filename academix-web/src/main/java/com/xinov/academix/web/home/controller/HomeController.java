package com.xinov.academix.web.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("home")
	public void showTestCalculatorPage(Model model) {

	}
	
	@RequestMapping("/")
	public String showDefaultPage() {
		return "forward:/login";
	}

}
