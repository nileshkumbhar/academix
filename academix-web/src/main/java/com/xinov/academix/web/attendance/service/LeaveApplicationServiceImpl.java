package com.xinov.academix.web.attendance.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xinov.academix.attendance.api.domain.LeaveApplication;
import com.xinov.academix.core.api.domain.User;
import com.xinov.academix.web.attendance.repository.LeaveApplicationRepository;

@Service
public class LeaveApplicationServiceImpl implements LeaveApplicationService {

	private @Autowired LeaveApplicationRepository leaveApplicationRepository;
	
	@Override
	public List<LeaveApplication> listByTeacher(User teacher) {
		return leaveApplicationRepository.findByTeacher(teacher);
	}

	@Override
	public List<LeaveApplication> listByParent(User parent) {
		List<LeaveApplication> result = new ArrayList<LeaveApplication>();
		for(User student : parent.getChildren()){
			result.addAll(leaveApplicationRepository.findByStudent(student));
		}
		return result;
	}

}
