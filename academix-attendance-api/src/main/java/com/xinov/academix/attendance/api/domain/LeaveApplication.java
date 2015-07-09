package com.xinov.academix.attendance.api.domain;

import java.io.Serializable;
import java.util.Date;

import com.xinov.academix.core.api.domain.SchoolInfo;
import com.xinov.academix.core.api.domain.Status;
import com.xinov.academix.core.api.domain.User;

public class LeaveApplication implements Serializable {

	private static final long serialVersionUID = 3070295645315197693L;

	private long id;
	private SchoolInfo schoolInfo;
	private User teacher;
	private User student;
	private Date applicationDate;
	private Date leaveFromDate;
	private Date leaveToDate;
	private String reason;
	private String applicationContent;
	private Status status;
	private boolean approved;
	
}
