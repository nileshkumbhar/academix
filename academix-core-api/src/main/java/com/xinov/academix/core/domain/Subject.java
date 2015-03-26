package com.xinov.academix.core.domain;

import java.io.Serializable;

public class Subject implements Serializable {

	private static final long serialVersionUID = -3654627722207429L;

	private int id;
	private String title;
	
	public Subject(int id, String title) {
		super();
		this.id = id;
		this.title = title;
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
}
