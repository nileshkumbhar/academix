package com.xinov.academix.web.attendance.controller;

import java.util.Date;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xinov.academix.attendance.api.domain.Attendance;
import com.xinov.academix.core.api.domain.User;
import com.xinov.academix.web.attendance.service.AttendanceService;
import com.xinov.academix.web.user.service.UserService;

@Controller
public class AttendanceReportController {
	
	private @Autowired AttendanceService attendanceService;
	private @Autowired UserService userService;

	@RequestMapping(value="attendanceReports", method=RequestMethod.GET)
	public void showAttendanceReportPage(){
		
	}
	
	
	/**
	* Handle request to download a PDF document
	*/
	@RequestMapping(value = "downloadReport", method = RequestMethod.GET)
	public ModelAndView downloadExcel(HttpSession session, HttpServletResponse response) {
		User teacher = userService.get(((User)session.getAttribute("user")).getUserId(), ((User)session.getAttribute("user")).getPassword());
		
		// create some sample data
		Date today  = new Date();
		Set<Attendance> attendances = attendanceService.load(userService.getAllClassesInSchool(teacher.getSchoolInfo().getId()).get(0), DateUtils.addMonths(today, -1), today);
	
//		new FileSystemResource(myService.getFileFor(fileName))
		// return a view which will be resolved by an excel view resolver
		
		response.addHeader("Content-Disposition",  "attachment; filename=\"attendance_sheet.pdf\"");
		
		return new ModelAndView("pdfView", "attendanceList", attendances);
	}
	
}
