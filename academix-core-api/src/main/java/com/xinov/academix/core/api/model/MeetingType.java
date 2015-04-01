package com.xinov.academix.core.api.model;

// Generated Mar 18, 2015 5:31:53 PM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * MeetingTypes generated by hbm2java
 */
@Entity
@Table(name = "acx_meeting_types")
public class MeetingType implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7433800344381539126L;
	
	private int id;
	private String title;
	private Set<Meeting> meetings = new HashSet<Meeting>(0);

	public MeetingType() {
	}

	public MeetingType(int id, String title) {
		this.id = id;
		this.title = title;
	}

	public MeetingType(int id, String title, Set<Meeting> meetings) {
		this.id = id;
		this.title = title;
		this.meetings = meetings;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "title", nullable = false, length = 45)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "MeetingTypes")
	public Set<Meeting> getMeetings() {
		return this.meetings;
	}

	public void setMeetings(Set<Meeting> meetings) {
		this.meetings = meetings;
	}

}