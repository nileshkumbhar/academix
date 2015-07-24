package com.xinov.academix.web.user.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.xinov.academix.core.api.domain.ClassMaster;
import com.xinov.academix.core.api.domain.ParentInfo;
import com.xinov.academix.core.api.domain.Role;
import com.xinov.academix.core.api.domain.SchoolInfo;
import com.xinov.academix.core.api.domain.StudentInfo;
import com.xinov.academix.core.api.domain.User;

@Repository
public class MockUserRepository implements UserRepository {

	private List<User> users;
	
	private SchoolInfo schoolInfo = new SchoolInfo(1, "ABC School", "___________", "022-34232321", "support@abc.com");
	private List<ClassMaster> classMasters = Arrays.asList(new ClassMaster(1, "Class 3C", schoolInfo));
	private List<Role> roles = Arrays.asList(new Role(1, "TEACHER"), new Role(2, "STUDENT"), new Role(3, "PARENT"));
	
	public MockUserRepository(){
		users = new ArrayList<User>();
		
		User teacher1 = new User();
		teacher1.setUserId("teacher1");
		teacher1.setPassword("teacher1");
		teacher1.setSchoolInfo(schoolInfo);
		teacher1.setName("Thomas Francis");
		teacher1.setContactNo("9930441501");
		teacher1.setEmailId("th.fr@abc.com");
		teacher1.setRoles(new HashSet<Role>(Arrays.asList(roles.get(0))));
		
		
		users.add(teacher1);
		
		users.addAll(createStudentAndParent("student1", schoolInfo, "Ajit Aagashe", "M", "Mohan"));
		users.addAll(createStudentAndParent("student2", schoolInfo, "Ketan Bhatia", "M", "Krishna"));
		users.addAll(createStudentAndParent("student3", schoolInfo, "Rohan Bhosale", "M", "Ashok"));
		users.addAll(createStudentAndParent("student4", schoolInfo, "Nita Chhabra", "F", "Aalok"));
		users.addAll(createStudentAndParent("student5", schoolInfo, "Avy Dorado", "F", "Edward"));
		users.addAll(createStudentAndParent("student6", schoolInfo, "Sejal Farhan", "F", "Aarif"));
		users.addAll(createStudentAndParent("student7", schoolInfo, "Meghana Goyal", "F", "Kishor"));
		users.addAll(createStudentAndParent("student8", schoolInfo, "Rahul Goyenka", "M", "Amit"));
		users.addAll(createStudentAndParent("student9", schoolInfo, "Ajinkya Khavare", "M", "Uddhav"));
		users.addAll(createStudentAndParent("student10", schoolInfo, "Vishakha Kurkure", "F", "Mukesh"));
		users.addAll(createStudentAndParent("student11", schoolInfo, "M Laksheeta", "F", "Ram"));
		users.addAll(createStudentAndParent("student12", schoolInfo, "Piyush Mane", "M", "Vinod"));
		users.addAll(createStudentAndParent("student13", schoolInfo, "Rita Nene", "F", "Mahendra"));
		users.addAll(createStudentAndParent("student14", schoolInfo, "Juthika Panda", "F", "Kamal"));
		users.addAll(createStudentAndParent("student15", schoolInfo, "Tejas Patel", "M", "Chimanbhai"));
		users.addAll(createStudentAndParent("student16", schoolInfo, "Chitra Patil", "F", "Laxman"));
		users.addAll(createStudentAndParent("student17", schoolInfo, "Laxmi Rao", "F", "Krishna"));
		users.addAll(createStudentAndParent("student18", schoolInfo, "Ashok Kumar Sharma", "M", "Sreedhar"));
		users.addAll(createStudentAndParent("student19", schoolInfo, "Rohit Kumar Sharma", "M", "Mohandas"));
		users.addAll(createStudentAndParent("student20", schoolInfo, "Rajesh Shinde", "M", "Prakash"));
		users.addAll(createStudentAndParent("student21", schoolInfo, "Jasmine Shaikh", "F", "Ajiz"));
		users.addAll(createStudentAndParent("student22", schoolInfo, "Teena T", "F", "Krishna"));
		users.addAll(createStudentAndParent("student23", schoolInfo, "Pravin Tandel", "M", "Suhas"));
		users.addAll(createStudentAndParent("student24", schoolInfo, "Madhav Tiwari", "M", "Kundan"));
		users.addAll(createStudentAndParent("student25", schoolInfo, "P Umashankar", "M", "Srinivasa"));
		users.addAll(createStudentAndParent("student26", schoolInfo, "Riya Verma", "F", "Vinay"));
		users.addAll(createStudentAndParent("student27", schoolInfo, "Yuvraj Vichare", "M", "Sarang"));
		users.addAll(createStudentAndParent("student28", schoolInfo, "Alok Waghmare", "M", "Mahesh"));
		users.addAll(createStudentAndParent("student29", schoolInfo, "Abhijeet Yadav", "M", "Avadhoot"));
		users.addAll(createStudentAndParent("student30", schoolInfo, "Vrinda Yadav", "F", "Umakant"));
		users.addAll(createStudentAndParent("student31", schoolInfo, "Irshaad Zamaadar", "M", "Tanveer"));
	}

	private List<User> createStudentAndParent(String userId, SchoolInfo schoolInfo, String name, String sex, String parentName) {
		List<User> studentAndParent = new ArrayList<User>();
		
		User student = new User();
		student.setUserId(userId);
		student.setSchoolInfo(schoolInfo);
		student.setName(name);
		student.setSex(sex);
		student.setRoles(new HashSet<Role>(Arrays.asList(roles.get(1))));
		student.setStudentInfo(new StudentInfo(Integer.parseInt(""+userId.substring(7)), ""+userId.substring(7), classMasters.get(0)));
		
		User parent = new User();
		String parentUserId = "parent"+Integer.parseInt(""+userId.substring(7));
		parent.setUserId(parentUserId);
		parent.setPassword(parentUserId);
		parent.setName(parentName + " " + student.getName().substring(student.getName().lastIndexOf(" ")));
		parent.setRoles(new HashSet<Role>(Arrays.asList(roles.get(2))));
		parent.setChildren(new HashSet<User>(Arrays.asList(student)));

		student.setParents(new HashSet<User>(Arrays.asList(parent)));
		
		studentAndParent.add(parent);
		studentAndParent.add(student);
		
		return studentAndParent;
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

	@Override
	public List<User> listStudents(int classId) {
		List<User> result = new ArrayList<User>();
		for(User user : users){
			if(isStudent(user) && isInClass(user, classId)){
				result.add(user);
			}
		}
		return result;
	}

	@Override
	public List<User> listAllParents() {
		List<User> result = new ArrayList<User>();
		for(User user : users){
			if(isParent(user)){
				result.add(user);
			}
		}
		return result;
	}

	private boolean isInClass(User user, int classId) {
		return (isStudent(user) && user.getStudentInfo() != null && user.getStudentInfo().getClassMaster().getId() == classId);
	}

	private boolean isStudent(User user) {
		for(Role role : user.getRoles()){
			if(role.getTitle().equalsIgnoreCase("STUDENT")){
				return true;
			}
		}
		return false;
	}
	
	private boolean isParent(User user) {
		for(Role role : user.getRoles()){
			if(role.getTitle().equalsIgnoreCase("PARENT")){
				return true;
			}
		}
		return false;
	}
}
