package com.xinov.academix.core.domain;

import java.io.Serializable;

public class Status implements Serializable {

	private static final long serialVersionUID = 2691694885666576410L;
	
	private int id;
	private String title;
	private String type;
	
	public Status(int id, String title, String type) {
		super();
		this.id = id;
		this.title = title;
		this.type = type;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}