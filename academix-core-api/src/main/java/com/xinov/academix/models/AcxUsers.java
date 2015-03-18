package com.xinov.academix.models;

// Generated Mar 17, 2015 12:04:16 AM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * AcxUsers generated by hbm2java
 */
public class AcxUsers implements java.io.Serializable {

	private String userId;
	private String password;
	private String name;
	private String address;
	private String contactNo;
	private String emailId;
	private int schoolId;
	private Date birthDate;
	private String sex;

	public AcxUsers() {
	}

	public AcxUsers(String userId, String password, String name,
			String address, String contactNo, String emailId, int schoolId) {
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.address = address;
		this.contactNo = contactNo;
		this.emailId = emailId;
		this.schoolId = schoolId;
	}

	public AcxUsers(String userId, String password, String name,
			String address, String contactNo, String emailId, int schoolId,
			Date birthDate, String sex) {
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.address = address;
		this.contactNo = contactNo;
		this.emailId = emailId;
		this.schoolId = schoolId;
		this.birthDate = birthDate;
		this.sex = sex;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNo() {
		return this.contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public int getSchoolId() {
		return this.schoolId;
	}

	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}

	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

}