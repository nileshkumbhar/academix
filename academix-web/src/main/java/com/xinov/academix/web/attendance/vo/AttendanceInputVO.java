package com.xinov.academix.web.attendance.vo;

import java.io.Serializable;

public class AttendanceInputVO implements Serializable {

	private static final long serialVersionUID = 6142789946991852984L;
	
	private String className;
	
	private String monthYear;

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getMonthYear() {
		return monthYear;
	}

	public void setMonthYear(String monthYear) {
		this.monthYear = monthYear;
	}
	
}
