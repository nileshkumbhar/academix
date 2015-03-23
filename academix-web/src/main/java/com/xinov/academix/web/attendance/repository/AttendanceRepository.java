package com.xinov.academix.web.attendance.repository;

import java.util.Date;
import java.util.Set;

import com.xinov.academix.core.model.Attendance;
import com.xinov.academix.core.model.ClassMaster;

public interface AttendanceRepository {

	void save(Set<Attendance> attendances);
	
	Set<Attendance> get(ClassMaster classMaster, Date fromDate, Date toDate);
}
