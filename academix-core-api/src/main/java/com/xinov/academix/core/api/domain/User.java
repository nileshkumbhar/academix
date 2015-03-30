package com.xinov.academix.core.api.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class User implements Serializable {

	private static final long serialVersionUID = -1952774027499637084L;

	private String userId;
	private String password;
	private String name;
	private String address;
	private String contactNo;
	private String emailId;
	private SchoolInfo schoolInfo;
	private Date birthDate;
	private String sex;
	
	private Set<User> parents;
	private Set<User> children;
	
	private Set<Document> documents;
	
	private Set<Role> roles;
	
	private ParentInfo parentInfo;
	private TeacherInfo teacherInfo;
	private StudentInfo studentInfo;
	
	private Status status;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public SchoolInfo getSchoolInfo() {
		return schoolInfo;
	}

	public void setSchoolInfo(SchoolInfo schoolInfo) {
		this.schoolInfo = schoolInfo;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Set<User> getParents() {
		return parents;
	}

	public void setParents(Set<User> parents) {
		this.parents = parents;
	}

	public Set<User> getChildren() {
		return children;
	}

	public void setChildren(Set<User> children) {
		this.children = children;
	}

	public Set<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(Set<Document> documents) {
		this.documents = documents;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public ParentInfo getParentInfo() {
		return parentInfo;
	}

	public void setParentInfo(ParentInfo parentInfo) {
		this.parentInfo = parentInfo;
	}

	public TeacherInfo getTeacherInfo() {
		return teacherInfo;
	}

	public void setTeacherInfo(TeacherInfo teacherInfo) {
		this.teacherInfo = teacherInfo;
	}

	public StudentInfo getStudentInfo() {
		return studentInfo;
	}

	public void setStudentInfo(StudentInfo studentInfo) {
		this.studentInfo = studentInfo;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
}
