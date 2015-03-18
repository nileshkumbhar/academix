package com.xinov.academix.models;

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
 * AcxMeetingTypes generated by hbm2java
 */
@Entity
@Table(name = "acx_meeting_types")
public class AcxMeetingTypes implements java.io.Serializable {

	private int id;
	private String title;
	private Set<AcxMeetings> acxMeetingses = new HashSet<AcxMeetings>(0);

	public AcxMeetingTypes() {
	}

	public AcxMeetingTypes(int id, String title) {
		this.id = id;
		this.title = title;
	}

	public AcxMeetingTypes(int id, String title, Set<AcxMeetings> acxMeetingses) {
		this.id = id;
		this.title = title;
		this.acxMeetingses = acxMeetingses;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "acxMeetingTypes")
	public Set<AcxMeetings> getAcxMeetingses() {
		return this.acxMeetingses;
	}

	public void setAcxMeetingses(Set<AcxMeetings> acxMeetingses) {
		this.acxMeetingses = acxMeetingses;
	}

}
