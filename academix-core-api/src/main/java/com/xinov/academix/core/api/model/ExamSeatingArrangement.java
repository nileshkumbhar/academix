package com.xinov.academix.core.api.model;

// Generated Mar 18, 2015 5:31:53 PM by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * ExamSeatingArrangement generated by hbm2java
 */
@Entity
@Table(name = "acx_exam_seating_arrangement")
public class ExamSeatingArrangement implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 493843648948914534L;
	
	private int id;
	private Examination examination;
	private User user;
	private String hallNo;

	public ExamSeatingArrangement() {
	}

	public ExamSeatingArrangement(int id, Examination examination,
			User user, String hallNo) {
		this.id = id;
		this.examination = examination;
		this.user = user;
		this.hallNo = hallNo;
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
	@JoinColumn(name = "exam_id", nullable = false)
	public Examination getExamination() {
		return this.examination;
	}

	public void setExamination(Examination examination) {
		this.examination = examination;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "student_id", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "hall_no", nullable = false, length = 45)
	public String getHallNo() {
		return this.hallNo;
	}

	public void setHallNo(String hallNo) {
		this.hallNo = hallNo;
	}

}
