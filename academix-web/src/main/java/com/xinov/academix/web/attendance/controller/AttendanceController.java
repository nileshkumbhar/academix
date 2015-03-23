package com.xinov.academix.web.attendance.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xinov.academix.core.model.User;
import com.xinov.academix.web.attendance.service.AttendanceService;
import com.xinov.academix.web.user.service.UserService;

@Controller
@RequestMapping("attendance")
public class AttendanceController {

	private @Autowired AttendanceService attendanceService;
	
	private @Autowired UserService userService;
	
	@RequestMapping(value="/verify", method=RequestMethod.GET)
	public String verifyAttendance(ModelMap modelMap, HttpSession session){
		User user = userService.get(((User)session.getAttribute("user")).getUserId(), ((User)session.getAttribute("user")).getPassword());
		modelMap.addAttribute("classes", userService.getAllClassesInSchool(user.getSchoolInfo().getId()));
		return "verifyAttendance";
	}
}
