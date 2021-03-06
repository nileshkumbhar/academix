package com.xinov.academix.core.api.model;

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
 * TeacherNotes generated by hbm2java
 */
@Entity
@Table(name = "acx_teacher_notes")
public class TeacherNote implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5515432648586248514L;
	
	private int id;
	private User user;
	private Date day;
	private String notes;

	public TeacherNote() {
	}

	public TeacherNote(int id, User user, String notes) {
		this.id = id;
		this.user = user;
		this.notes = notes;
	}

	public TeacherNote(int id, User user, Date day, String notes) {
		this.id = id;
		this.user = user;
		this.day = day;
		this.notes = notes;
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
	@JoinColumn(name = "teacher_id", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "day", length = 19)
	public Date getDay() {
		return this.day;
	}

	public void setDay(Date day) {
		this.day = day;
	}

	@Column(name = "notes", nullable = false, length = 4000)
	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}
