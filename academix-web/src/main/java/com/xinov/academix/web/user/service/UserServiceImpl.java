package com.xinov.academix.web.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xinov.academix.core.api.model.ClassMaster;
import com.xinov.academix.core.api.model.User;
import com.xinov.academix.web.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private @Autowired UserRepository userRepository;

	@Override
	public User get(String userId, String password) {
		return userRepository.get(userId, password);
	}

	@Override
	public List<ClassMaster> getAllClassesInSchool(int schoolId) {
		return userRepository.getAllClassesInSchool(schoolId);
	}

	@Override
	public List<User> getStudentsInClass(int classId) {
		return userRepository.listStudents(classId);
	}

}
