package com.xinov.academix.web.attendance.controller;

import javax.servlet.http.HttpSession; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xinov.academix.core.api.domain.Role;
import com.xinov.academix.core.api.domain.User;
import com.xinov.academix.web.attendance.service.LeaveApplicationService;
import com.xinov.academix.web.user.service.UserService;

@Controller
public class LeaveApplicationController {

	private @Autowired LeaveApplicationService leaveApplicationService;
	
	private @Autowired UserService userService;
	
	@RequestMapping(value="leaveApplications", method=RequestMethod.GET)
	public Model showAttendanceReportPage(Model model, HttpSession session){
		User user = userService.get(((User)session.getAttribute("user")).getUserId(), ((User)session.getAttribute("user")).getPassword());
		
		if(user.getRoles().contains(new Role(1, "TEACHER"))){
			model.addAttribute("leaveApplications", leaveApplicationService.listByTeacher(user));
		}
		
		if(user.getRoles().contains(new Role(3, "PARENT"))){
			model.addAttribute("leaveApplications", leaveApplicationService.listByParent(user));
		}

		return model;
	}
}
