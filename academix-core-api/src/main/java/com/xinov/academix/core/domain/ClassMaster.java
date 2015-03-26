package com.xinov.academix.core.domain;

import java.io.Serializable;

public class ClassMaster implements Serializable {

	private static final long serialVersionUID = 8621190293281476070L;
	
	private int id;
	private String title;
	private SchoolInfo schoolInfo;
	

	public ClassMaster(int id, String title, SchoolInfo schoolInfo) {
		super();
		this.id = id;
		this.title = title;
		this.schoolInfo = schoolInfo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public SchoolInfo getSchoolInfo() {
		return schoolInfo;
	}

	public void setSchoolInfo(SchoolInfo schoolInfo) {
		this.schoolInfo = schoolInfo;
	}

	  
}
