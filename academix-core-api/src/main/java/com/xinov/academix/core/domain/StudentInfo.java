package com.xinov.academix.core.domain;

import java.io.Serializable;

public class StudentInfo implements Serializable {

	private static final long serialVersionUID = 1532081511882830920L;
	
	private int id;
	private String rollNumber;
	private ClassMaster classMaster;
	
	public StudentInfo(int id, String rollNumber, ClassMaster classMaster) {
		super();
		this.id = id;
		this.rollNumber = rollNumber;
		this.classMaster = classMaster;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}

	public ClassMaster getClassMaster() {
		return classMaster;
	}

	public void setClassMaster(ClassMaster classMaster) {
		this.classMaster = classMaster;
	}
	
	
}
