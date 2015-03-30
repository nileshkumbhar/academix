package com.xinov.academix.web.attendance.repository;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xinov.academix.attendance.api.domain.Attendance;
import com.xinov.academix.core.api.domain.ClassMaster;
import com.xinov.academix.core.api.domain.User;
import com.xinov.academix.web.user.repository.UserRepository;

@Repository
public class MockAttendanceRepository implements AttendanceRepository {

	private Set<Attendance> attendanceData = new HashSet<Attendance>();
	
	private @Autowired UserRepository userRepository;
	
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

	@Override
	public Set<Attendance> get(ClassMaster classMaster, User teacher, Date date) {
		Set<Attendance> result = new HashSet<Attendance>();
		List<User> students = userRepository.listStudents(classMaster.getId());
		for(int count = 0 ; count < students.size(); count++){
			result.add(new Attendance(count, classMaster.getSchoolInfo(), date, classMaster, teacher, students.get(count), true, null));
		}
		return result;
	}

}
