package com.xinov.academix.web.attendance.service;

import java.util.Date;
import java.util.Set;

import com.xinov.academix.attendance.api.domain.Attendance;
import com.xinov.academix.core.api.domain.ClassMaster;
import com.xinov.academix.core.api.domain.User;

public interface AttendanceService {

	void save(Set<Attendance> attendances);
	
	Set<Attendance> load(ClassMaster classMaster, Date fromDate, Date toDate);
	
	Set<Attendance> load(ClassMaster classMaster, User teacher, Date date);
}
