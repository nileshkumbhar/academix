package com.xinov.academix.web.attendance.controller;

import java.util.Date;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xinov.academix.attendance.api.domain.Attendance;
import com.xinov.academix.core.api.domain.ClassMaster;
import com.xinov.academix.core.api.domain.User;
import com.xinov.academix.web.attendance.service.AttendanceService;
import com.xinov.academix.web.user.service.UserService;

@Controller
public class VerifyAttendanceController {

	private @Autowired AttendanceService attendanceService;
	
	private @Autowired UserService userService;
	
	@RequestMapping(value="verifyAttendance", method=RequestMethod.GET)
	public void verifyAttendance(ModelMap modelMap, HttpSession session){
		User user = userService.get(((User)session.getAttribute("user")).getUserId(), ((User)session.getAttribute("user")).getPassword());
		modelMap.addAttribute("classes", userService.getAllClassesInSchool(user.getSchoolInfo().getId()));
	}
	
	@RequestMapping(value="loadAttendanceSheet", method=RequestMethod.GET)
	public @ResponseBody Set<Attendance> loadAttendanceSheet(@RequestParam("classId") int classId, HttpSession session){
		User teacher = userService.get(((User)session.getAttribute("user")).getUserId(), ((User)session.getAttribute("user")).getPassword());
		
		ClassMaster currentClassMaster = null;
		for(ClassMaster classMaster : userService.getAllClassesInSchool(teacher.getSchoolInfo().getId())){
			if(classId == classMaster.getId()){
				currentClassMaster = classMaster;
			}
		}
		return attendanceService.load(currentClassMaster, teacher, new Date());
	}
}
