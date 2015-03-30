package com.xinov.academix.web.user.repository;

import java.util.List;

import com.xinov.academix.core.api.model.ClassMaster;
import com.xinov.academix.core.api.model.User;

public interface UserRepository {

	User get(String userId, String password);
	
	List<ClassMaster> getAllClassesInSchool(int schoolId);

	List<User> listStudents(int classId);
}
