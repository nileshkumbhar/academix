package com.xinov.academix.web.attendance.service;

import java.util.Date;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xinov.academix.attendance.api.domain.Attendance;
import com.xinov.academix.core.api.domain.ClassMaster;
import com.xinov.academix.core.api.domain.User;
import com.xinov.academix.web.attendance.repository.AttendanceRepository;

@Service
public class AttendanceServiceImpl implements AttendanceService {

	private @Autowired AttendanceRepository attendanceRepository;
	
	@Override
	public void save(Set<Attendance> attendances) {
		attendanceRepository.save(attendances);
	}

	@Override
	public Set<Attendance> load(ClassMaster classMaster, Date fromDate,
			Date toDate) {
		return attendanceRepository.get(classMaster, fromDate, toDate);
	}

	@Override
	public Set<Attendance> load(ClassMaster classMaster, User teacher, Date date) {
		return attendanceRepository.get(classMaster, teacher, date);
	}
}