package com.xinov.academix.models;

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
 * AcxStudentHealth generated by hbm2java
 */
@Entity
@Table(name = "acx_student_health")
public class AcxStudentHealth implements java.io.Serializable {

	private int id;
	private AcxUsers acxUsers;
	private Date day;
	private int height;
	private int weight;
	private String healthRemarks;

	public AcxStudentHealth() {
	}

	public AcxStudentHealth(int id, AcxUsers acxUsers, int height, int weight) {
		this.id = id;
		this.acxUsers = acxUsers;
		this.height = height;
		this.weight = weight;
	}

	public AcxStudentHealth(int id, AcxUsers acxUsers, Date day, int height,
			int weight, String healthRemarks) {
		this.id = id;
		this.acxUsers = acxUsers;
		this.day = day;
		this.height = height;
		this.weight = weight;
		this.healthRemarks = healthRemarks;
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
	@JoinColumn(name = "student_id", nullable = false)
	public AcxUsers getAcxUsers() {
		return this.acxUsers;
	}

	public void setAcxUsers(AcxUsers acxUsers) {
		this.acxUsers = acxUsers;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "day", length = 19)
	public Date getDay() {
		return this.day;
	}

	public void setDay(Date day) {
		this.day = day;
	}

	@Column(name = "height", nullable = false)
	public int getHeight() {
		return this.height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Column(name = "weight", nullable = false)
	public int getWeight() {
		return this.weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Column(name = "health_remarks")
	public String getHealthRemarks() {
		return this.healthRemarks;
	}

	public void setHealthRemarks(String healthRemarks) {
		this.healthRemarks = healthRemarks;
	}

}
