package com.xinov.academix.web.user.repository;

import java.util.List;

import com.xinov.academix.core.api.domain.ClassMaster;
import com.xinov.academix.core.api.domain.User;

public interface UserRepository {

	User get(String userId, String password);
	
	List<ClassMaster> getAllClassesInSchool(int schoolId);

	List<User> listStudents(int classId);
	
	List<User> listAllParents();
}
