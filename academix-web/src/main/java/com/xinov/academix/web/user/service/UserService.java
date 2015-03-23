package com.xinov.academix.web.user.service;

import java.util.List;

import com.xinov.academix.core.model.ClassMaster;
import com.xinov.academix.core.model.User;

public interface UserService {

	User get(String userId, String password);
	
	List<ClassMaster> getAllClassesInSchool(int schoolId);
}
