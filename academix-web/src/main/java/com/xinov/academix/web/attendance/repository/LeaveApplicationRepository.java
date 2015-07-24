package com.xinov.academix.web.attendance.repository;

import java.util.Date;
import java.util.List;

import com.xinov.academix.attendance.api.domain.LeaveApplication;
import com.xinov.academix.core.api.domain.User;

public interface LeaveApplicationRepository {

	List<LeaveApplication> list();
	
	LeaveApplication find(long id);
	
	List<LeaveApplication> findByTeacher(User teacher);
	
	List<LeaveApplication> findByStudent(User student);
	
	LeaveApplication findByStudentAndDate(User student, Date date);
	
	void create(LeaveApplication leaveApplication);
	
	void update(LeaveApplication leaveApplication);
	
	void delete(LeaveApplication leaveApplication);
	
}
