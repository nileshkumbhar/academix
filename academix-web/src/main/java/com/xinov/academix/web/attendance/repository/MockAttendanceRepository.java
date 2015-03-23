package com.xinov.academix.web.attendance.repository;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.xinov.academix.core.model.Attendance;
import com.xinov.academix.core.model.ClassMaster;

@Repository
public class MockAttendanceRepository implements AttendanceRepository {

	private Set<Attendance> attendanceData = new HashSet<Attendance>();
	
	@Override
	public void save(Set<Attendance> attendances) {
		attendanceData.addAll(attendances);
	}

	@Override
	public Set<Attendance> get(ClassMaster classMaster, Date fromDate,
			Date toDate) {
		Set<Attendance> result = new HashSet<Attendance>();
		for (Attendance attendance : attendanceData) {
			if (attendance.getClassMaster().getId() == classMaster.getId()
					&& attendance.getDate().before(toDate)
					&& attendance.getDate().after(fromDate)) {
				result.add(attendance);
			}
		}
		return result;
	}

}
