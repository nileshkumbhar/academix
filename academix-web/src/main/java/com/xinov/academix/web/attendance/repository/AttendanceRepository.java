package com.xinov.academix.web.attendance.repository;

import java.util.Date;
import java.util.Set;

import com.xinov.academix.attendance.api.domain.Attendance;
import com.xinov.academix.core.api.domain.ClassMaster;
import com.xinov.academix.core.api.domain.User;

public interface AttendanceRepository {

	void save(Set<Attendance> attendances);
	
	Set<Attendance> get(ClassMaster classMaster, Date fromDate, Date toDate);

	Set<Attendance> get(ClassMaster classMaster, User teacher, Date date);
}
