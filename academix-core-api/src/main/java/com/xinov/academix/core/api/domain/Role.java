package com.xinov.academix.core.api.domain;

import java.io.Serializable;

public class Role implements Serializable {

	private static final long serialVersionUID = 5738417024166414060L;
	
	private int id;
	private String title;
	
	public Role(int id, String title) {
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