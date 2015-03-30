package com.xinov.academix.attendance.api.domain;

import java.io.Serializable;
import java.util.Date;

import com.xinov.academix.core.api.domain.ClassMaster;
import com.xinov.academix.core.api.domain.SchoolInfo;
import com.xinov.academix.core.api.domain.User;

public class Attendance implements Serializable {

	private static final long serialVersionUID = -743165971145285653L;

	private long id;
	private SchoolInfo schoolInfo;
	private Date date;
	private ClassMaster classMaster;
	private User teacher;
	private User student;
	private boolean present = true;
	private String absentReason;
	
	public Attendance() {
		super();
	}

	public Attendance(long id, SchoolInfo schoolInfo, Date date,
			ClassMaster classMaster, User teacher, User student,
			boolean present, String absentReason) {
		super();
		this.id = id;
		this.schoolInfo = schoolInfo;
		this.date = date;
		this.classMaster = classMaster;
		this.teacher = teacher;
		this.student = student;
		this.present = present;
		this.absentReason = absentReason;
	}

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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public ClassMaster getClassMaster() {
		return classMaster;
	}

	public void setClassMaster(ClassMaster classMaster) {
		this.classMaster = classMaster;
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

	public boolean isPresent() {
		return present;
	}

	public void setPresent(boolean present) {
		this.present = present;
	}

	public String getAbsentReason() {
		return absentReason;
	}

	public void setAbsentReason(String absentReason) {
		this.absentReason = absentReason;
	}
}