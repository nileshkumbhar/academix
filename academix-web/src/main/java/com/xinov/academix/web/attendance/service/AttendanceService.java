package com.xinov.academix.web.attendance.service;

import java.util.Date;
import java.util.Set;

import com.xinov.academix.core.model.Attendance;
import com.xinov.academix.core.model.ClassMaster;
import com.xinov.academix.core.model.User;

public interface AttendanceService {

	void save(Set<Attendance> attendances);
	
	Set<Attendance> load(ClassMaster classMaster, Date fromDate, Date toDate);
	
	Set<Attendance> load(ClassMaster classMaster, User teacher, Date date);
}
