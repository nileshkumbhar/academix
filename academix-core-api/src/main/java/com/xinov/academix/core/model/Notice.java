package com.xinov.academix.core.model;

// Generated Mar 18, 2015 5:31:53 PM by Hibernate Tools 4.3.1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * AcxNotices generated by hbm2java
 */
@Entity
@Table(name = "acx_notices")
public class Notice implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2220738904469643567L;
	
	private int id;
	private ClassMaster acxClassMaster;
	private NoticeType acxNoticeTypes;
	private SchoolInfo acxSchoolMaster;
	private User acxUsers;
	private String notice;
	private Date startDate;
	private Date endDate;

	public Notice() {
	}

	public Notice(int id, NoticeType acxNoticeTypes,
			SchoolInfo acxSchoolMaster, User acxUsers, String notice) {
		this.id = id;
		this.acxNoticeTypes = acxNoticeTypes;
		this.acxSchoolMaster = acxSchoolMaster;
		this.acxUsers = acxUsers;
		this.notice = notice;
	}

	public Notice(int id, ClassMaster acxClassMaster,
			NoticeType acxNoticeTypes, SchoolInfo acxSchoolMaster,
			User acxUsers, String notice, Date startDate, Date endDate) {
		this.id = id;
		this.acxClassMaster = acxClassMaster;
		this.acxNoticeTypes = acxNoticeTypes;
		this.acxSchoolMaster = acxSchoolMaster;
		this.acxUsers = acxUsers;
		this.notice = notice;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "class_id")
	public ClassMaster getAcxClassMaster() {
		return this.acxClassMaster;
	}

	public void setAcxClassMaster(ClassMaster acxClassMaster) {
		this.acxClassMaster = acxClassMaster;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "notice_type", nullable = false)
	public NoticeType getAcxNoticeTypes() {
		return this.acxNoticeTypes;
	}

	public void setAcxNoticeTypes(NoticeType acxNoticeTypes) {
		this.acxNoticeTypes = acxNoticeTypes;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "school_id", nullable = false)
	public SchoolInfo getAcxSchoolMaster() {
		return this.acxSchoolMaster;
	}

	public void setAcxSchoolMaster(SchoolInfo acxSchoolMaster) {
		this.acxSchoolMaster = acxSchoolMaster;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "issuer_id", nullable = false)
	public User getAcxUsers() {
		return this.acxUsers;
	}

	public void setAcxUsers(User acxUsers) {
		this.acxUsers = acxUsers;
	}

	@Column(name = "notice", nullable = false, length = 1000)
	public String getNotice() {
		return this.notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "start_date", length = 19)
	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "end_date", length = 19)
	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}