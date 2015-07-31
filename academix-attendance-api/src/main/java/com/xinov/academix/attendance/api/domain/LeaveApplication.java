package com.xinov.academix.attendance.api.domain;

import java.io.Serializable;
import java.util.Date;

import com.xinov.academix.core.api.domain.SchoolInfo;
import com.xinov.academix.core.api.domain.Status;
import com.xinov.academix.core.api.domain.User;

public class LeaveApplication implements Serializable {

	private static final long serialVersionUID = 3070295645315197693L;

	private long id;
	private SchoolInfo schoolInfo;
	private User teacher;
	private User student;
	private User applicant;
	private Date applicationDate;
	private Date leaveFromDate;
	private Date leaveToDate;
	private String reason;
	private String applicationContent;
	private Status status;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public SchoolInfo getSchoolInfo() {
		return schoolInfo;
	}
	public void setSchoolInfo(SchoolInfo schoolInfo) {
		this.schoolInfo = schoolInfo;
	}
	public User getTeacher() {
		return teacher;
	}
	public void setTeacher(User teacher) {
		this.teacher = teacher;
	}
	public User getStudent() {
		return student;
	}
	public void setStudent(User student) {
		this.student = student;
	}
	public User getApplicant() {
		return applicant;
	}
	public void setApplicant(User applicant) {
		this.applicant = applicant;
	}
	public Date getApplicationDate() {
		return applicationDate;
	}
	public void setApplicationDate(Date applicationDate) {
		this.applicationDate = applicationDate;
	}
	public Date getLeaveFromDate() {
		return leaveFromDate;
	}
	public void setLeaveFromDate(Date leaveFromDate) {
		this.leaveFromDate = leaveFromDate;
	}
	public Date getLeaveToDate() {
		return leaveToDate;
	}
	public void setLeaveToDate(Date leaveToDate) {
		this.leaveToDate = leaveToDate;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getApplicationContent() {
		return applicationContent;
	}
	public void setApplicationContent(String applicationContent) {
		this.applicationContent = applicationContent;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
}
