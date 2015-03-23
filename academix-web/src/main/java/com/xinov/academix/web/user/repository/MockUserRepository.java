package com.xinov.academix.web.user.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.xinov.academix.core.model.ClassMaster;
import com.xinov.academix.core.model.Role;
import com.xinov.academix.core.model.SchoolInfo;
import com.xinov.academix.core.model.StudentInfo;
import com.xinov.academix.core.model.User;
import com.xinov.academix.core.model.UserRole;

@Repository
public class MockUserRepository implements UserRepository {

	private List<User> users;
	
	private SchoolInfo schoolInfo = new SchoolInfo(1, "ABC School", "___________", "022-34232321", "support@abc.com");
	private List<ClassMaster> classMasters = Arrays.asList(new ClassMaster(1, schoolInfo, "Class 3C"));
	private List<Role> roles = Arrays.asList(new Role(1, "TEACHER"), new Role(2, "STUDENT"));
	
	public MockUserRepository(){
		users = new ArrayList<User>();
		
		User teacher1 = new User("teacher1", schoolInfo, "teacher1", "Thomas Francis", "              ", "9930441501", "th.fr@abc.com");
		teacher1.setUserRoles(new HashSet<UserRole>(Arrays.asList(new UserRole(31, roles.get(0), teacher1))));
		
		
		users.add(teacher1);
		
		users.add(createStudent("student1", schoolInfo, "Ajit Aagashe"));
		users.add(createStudent("student2", schoolInfo, "Ketan Bhatia"));
		users.add(createStudent("student3", schoolInfo, "Rohan Bhosale"));
		users.add(createStudent("student4", schoolInfo, "Nita Chhabra"));
		users.add(createStudent("student5", schoolInfo, "Avy Dorado"));
		users.add(createStudent("student6", schoolInfo, "Sejal Farhan"));
		users.add(createStudent("student7", schoolInfo, "Meghana Goyal"));
		users.add(createStudent("student8", schoolInfo, "Rahul Goyenka"));
		users.add(createStudent("student9", schoolInfo, "Ajinkya Khavare"));
		users.add(createStudent("student10", schoolInfo, "Vishakha Kurkure"));
		users.add(createStudent("student11", schoolInfo, "M Laksheeta"));
		users.add(createStudent("student12", schoolInfo, "Piyush Mane"));
		users.add(createStudent("student13", schoolInfo, "Rita Nene"));
		users.add(createStudent("student14", schoolInfo, "Juthika Panda"));
		users.add(createStudent("student15", schoolInfo, "Tejas Patel"));
		users.add(createStudent("student16", schoolInfo, "Chitra Patil"));
		users.add(createStudent("student17", schoolInfo, "Laxmi Rao"));
		users.add(createStudent("student18", schoolInfo, "Ashok Kumar Sharma"));
		users.add(createStudent("student19", schoolInfo, "Rohit Kumar Sharma"));
		users.add(createStudent("student20", schoolInfo, "Rajesh Shinde"));
		users.add(createStudent("student21", schoolInfo, "Jasmine Shaikh"));
		users.add(createStudent("student22", schoolInfo, "Teena T"));
		users.add(createStudent("student23", schoolInfo, "Pravin Tandel"));
		users.add(createStudent("student24", schoolInfo, "Madhav Tiwari"));
		users.add(createStudent("student25", schoolInfo, "P Umashankar"));
		users.add(createStudent("student26", schoolInfo, "Yuvraj Vichare"));
		users.add(createStudent("student27", schoolInfo, "Alok Waghmare"));
	}

	private User createStudent(String userId, SchoolInfo schoolInfo, String name) {
		User student = new User(userId, schoolInfo, userId, name, "", "", "");
		student.setUserRoles(new HashSet<UserRole>(Arrays.asList(new UserRole(Integer.parseInt(""+userId.charAt(userId.length()-1)), roles.get(1), student))));
		student.setStudentInfos(new HashSet<StudentInfo>(Arrays.asList(new StudentInfo(Integer.parseInt(""+userId.charAt(userId.length()-1)), classMasters.get(0), student, ""+userId.charAt(userId.length()-1)))));
		
		return student;
	}
	
	@Override
	public User get(String userId, String password) {
		for(User user : users){
			if(user.getUserId().equals(userId) && user.getPassword().equals(password)){
				return user;
			}
		}
		return null;
	}
	
	public List<ClassMaster> getAllClassesInSchool(int schoolId){
		List<ClassMaster> result = new ArrayList<ClassMaster>();
		for (ClassMaster classMaster : classMasters) {
			if (classMaster.getSchoolInfo().getId() == schoolId) {
				result.add(classMaster);
			}
		}
		return result;
	}

}
