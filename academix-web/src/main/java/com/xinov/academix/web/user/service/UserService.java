package com.xinov.academix.web.user.service;

import java.util.List;

import com.xinov.academix.core.api.domain.ClassMaster;
import com.xinov.academix.core.api.domain.User;

public interface UserService {

	User get(String userId, String password);
	
	List<ClassMaster> getAllClassesInSchool(int schoolId);
	
	List<User> getStudentsInClass(int classId);
}
