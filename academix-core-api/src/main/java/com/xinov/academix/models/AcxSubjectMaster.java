package com.xinov.academix.models;

// Generated Mar 17, 2015 12:04:16 AM by Hibernate Tools 3.4.0.CR1

/**
 * AcxSubjectMaster generated by hbm2java
 */
public class AcxSubjectMaster implements java.io.Serializable {

	private int id;
	private String title;

	public AcxSubjectMaster() {
	}

	public AcxSubjectMaster(int id, String title) {
		this.id = id;
		this.title = title;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
