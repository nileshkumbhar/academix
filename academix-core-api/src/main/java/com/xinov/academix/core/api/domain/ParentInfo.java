package com.xinov.academix.core.api.domain;

import java.io.Serializable;

public class ParentInfo implements Serializable {

	private static final long serialVersionUID = -3872837154711980079L;

	private long id;
	private String occupation;
	private String qualification;
	private double annualIncome;
	private String relation;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	public double getAnnualIncome() {
		return annualIncome;
	}
	public void setAnnualIncome(double annualIncome) {
		this.annualIncome = annualIncome;
	}
	
	

}
