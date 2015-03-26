package com.xinov.academix.core.domain;

import java.io.Serializable;

public class SchoolInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private String address;
	private String phone_no;
	private String email_id;
	
	public SchoolInfo() {
		super();
	}

	public SchoolInfo(int id, String name, String address, String phone_no,
			String email_id) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone_no = phone_no;
		this.email_id = email_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

}
