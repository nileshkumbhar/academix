package com.xinov.academix.web.attendance.service;

import java.util.List;

import com.xinov.academix.attendance.api.domain.LeaveApplication;
import com.xinov.academix.core.api.domain.User;

public interface LeaveApplicationService {

	List<LeaveApplication> listByTeacher(User teacher);
}
