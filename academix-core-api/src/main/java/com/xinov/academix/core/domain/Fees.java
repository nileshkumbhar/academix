package com.xinov.academix.core.domain;

import java.io.Serializable;

public class Fees implements Serializable {

	private static final long serialVersionUID = 2295278172182781873L;
	
	private int id;
	private String title;
	private double fees;
	
	public Fees(int id, String title, double fees) {
		super();
		this.id = id;
		this.title = title;
		this.fees = fees;
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

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}
	
}
