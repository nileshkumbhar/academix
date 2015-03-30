package com.xinov.academix.core.api.domain;

import java.io.Serializable;
import java.util.Set;

public class TeacherInfo implements Serializable {

	private static final long serialVersionUID = 1701551810412920800L;

	private long id;
	private String qualification;
	private Set<Subject> subjects;
	
	public TeacherInfo(long id, String qualification, Set<Subject> subjects) {
		super();
		this.id = id;
		this.qualification = qualification;
		this.subjects = subjects;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public Set<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}
	
}
