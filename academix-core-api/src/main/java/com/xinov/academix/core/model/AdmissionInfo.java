package com.xinov.academix.core.model;

// Generated Mar 18, 2015 5:31:53 PM by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * AdmissionInfo generated by hbm2java
 */
@Entity
@Table(name = "acx_admission_info")
public class AdmissionInfo implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8270394198684257094L;
	
	private String applicationId;
	private Status status;
	private User user;
	private String applicantName;
	private String applicantContactNo;
	private String applicantEmail;
	private Date applicationStatusModifiedOn;
	private String remarks;
	private Set<AdmissionFees> admissionFees = new HashSet<AdmissionFees>(
			0);
	private Set<AdmissionDocument> admissionDocuments = new HashSet<AdmissionDocument>(
			0);

	public AdmissionInfo() {
	}

	public AdmissionInfo(String applicationId,
			Status status, User user,
			String applicantName, String applicantContactNo,
			String applicantEmail) {
		this.applicationId = applicationId;
		this.status = status;
		this.user = user;
		this.applicantName = applicantName;
		this.applicantContactNo = applicantContactNo;
		this.applicantEmail = applicantEmail;
	}

	public AdmissionInfo(String applicationId,
			Status status, User user,
			String applicantName, String applicantContactNo,
			String applicantEmail, Date applicationStatusModifiedOn,
			String remarks, Set<AdmissionFees> admissionFees,
			Set<AdmissionDocument> admissionDocuments) {
		this.applicationId = applicationId;
		this.status = status;
		this.user = user;
		this.applicantName = applicantName;
		this.applicantContactNo = applicantContactNo;
		this.applicantEmail = applicantEmail;
		this.applicationStatusModifiedOn = applicationStatusModifiedOn;
		this.remarks = remarks;
		this.admissionFees = admissionFees;
		this.admissionDocuments = admissionDocuments;
	}

	@Id
	@Column(name = "application_id", unique = true, nullable = false, length = 45)
	public String getApplicationId() {
		return this.applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "application_status", nullable = false)
	public Status getStatusMaster() {
		return this.status;
	}

	public void setStatusMaster(Status status) {
		this.status = status;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "application_status_modified_by", nullable = false)
	public User getUsers() {
		return this.user;
	}

	public void setUsers(User user) {
		this.user = user;
	}

	@Column(name = "applicant_name", nullable = false, length = 45)
	public String getApplicantName() {
		return this.applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	@Column(name = "applicant_contact_no", nullable = false, length = 45)
	public String getApplicantContactNo() {
		return this.applicantContactNo;
	}

	public void setApplicantContactNo(String applicantContactNo) {
		this.applicantContactNo = applicantContactNo;
	}

	@Column(name = "applicant_email", nullable = false, length = 100)
	public String getApplicantEmail() {
		return this.applicantEmail;
	}

	public void setApplicantEmail(String applicantEmail) {
		this.applicantEmail = applicantEmail;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "application_status_modified_on", length = 19)
	public Date getApplicationStatusModifiedOn() {
		return this.applicationStatusModifiedOn;
	}

	public void setApplicationStatusModifiedOn(Date applicationStatusModifiedOn) {
		this.applicationStatusModifiedOn = applicationStatusModifiedOn;
	}

	@Column(name = "remarks")
	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "AdmissionInfo")
	public Set<AdmissionFees> getAdmissionFees() {
		return this.admissionFees;
	}

	public void setAdmissionFees(Set<AdmissionFees> admissionFees) {
		this.admissionFees = admissionFees;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "AdmissionInfo")
	public Set<AdmissionDocument> getAdmissionDocumentses() {
		return this.admissionDocuments;
	}

	public void setAdmissionDocumentses(
			Set<AdmissionDocument> AdmissionDocumentses) {
		this.admissionDocuments = AdmissionDocumentses;
	}

}
