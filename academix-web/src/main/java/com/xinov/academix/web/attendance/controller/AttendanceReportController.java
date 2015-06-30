package com.xinov.academix.web.attendance.controller;

import java.text.ParseException;
import java.util.Date;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xinov.academix.attendance.api.domain.Attendance;
import com.xinov.academix.core.api.domain.User;
import com.xinov.academix.web.attendance.service.AttendanceService;
import com.xinov.academix.web.attendance.vo.AttendanceInputVO;
import com.xinov.academix.web.user.service.UserService;

@Controller
public class AttendanceReportController {
	
	private @Autowired AttendanceService attendanceService;
	private @Autowired UserService userService;

	@RequestMapping(value="attendanceReports", method=RequestMethod.GET)
	public Model showAttendanceReportPage(Model model, HttpSession session){
		User teacher = userService.get(((User)session.getAttribute("user")).getUserId(), ((User)session.getAttribute("user")).getPassword());
		
		model.addAttribute("attendanceInput", new AttendanceInputVO());
		model.addAttribute("classes", userService.getAllClassesInSchool(teacher.getSchoolInfo().getId()));
		
		return model;
	}
	
	
	/**
	* Handle request to download a PDF document
	 * @throws ParseException 
	*/
	@RequestMapping(value = "downloadReport", method = RequestMethod.POST)
	public ModelAndView downloadRport(HttpSession session, HttpServletResponse response, @ModelAttribute("attendanceInput") AttendanceInputVO attendanceInputVO) throws ParseException {
		User teacher = userService.get(((User)session.getAttribute("user")).getUserId(), ((User)session.getAttribute("user")).getPassword());
		
		// create some sample data
		Date startDate = DateUtils.parseDate("01-"+attendanceInputVO.getMonthYear(), new String[]{"dd-MM-yyyy"});
		Date endDate = DateUtils.addMonths(startDate, 1);
		Set<Attendance> attendances = attendanceService.load(userService.getAllClassesInSchool(teacher.getSchoolInfo().getId()).get(0), startDate, endDate);
	
//		new FileSystemResource(myService.getFileFor(fileName))
		// return a view which will be resolved by an excel view resolver
		
		response.addHeader("Content-Disposition",  "attachment; filename=\"attendance_sheet.pdf\"");
		
		return new ModelAndView("pdfView", "attendanceList", attendances);
	}
	
}
