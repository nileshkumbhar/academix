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
 * AcxFeesMaster generated by hbm2java
 */
@Entity
@Table(name = "acx_fees_master")
public class AcxFeesMaster implements java.io.Serializable {

	private int id;
	private String title;
	private int fees;
	private Set<AcxAdmissionFees> acxAdmissionFeeses = new HashSet<AcxAdmissionFees>(
			0);

	public AcxFeesMaster() {
	}

	public AcxFeesMaster(int id, String title, int fees) {
		this.id = id;
		this.title = title;
		this.fees = fees;
	}

	public AcxFeesMaster(int id, String title, int fees,
			Set<AcxAdmissionFees> acxAdmissionFeeses) {
		this.id = id;
		this.title = title;
		this.fees = fees;
		this.acxAdmissionFeeses = acxAdmissionFeeses;
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

	@Column(name = "fees", nullable = false)
	public int getFees() {
		return this.fees;
	}

	public void setFees(int fees) {
		this.fees = fees;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "acxFeesMaster")
	public Set<AcxAdmissionFees> getAcxAdmissionFeeses() {
		return this.acxAdmissionFeeses;
	}

	public void setAcxAdmissionFeeses(Set<AcxAdmissionFees> acxAdmissionFeeses) {
		this.acxAdmissionFeeses = acxAdmissionFeeses;
	}

}
