package com.xinov.academix.models;

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
 * AcxAdmissionInfo generated by hbm2java
 */
@Entity
@Table(name = "acx_admission_info")
public class AcxAdmissionInfo implements java.io.Serializable {

	private String applicationId;
	private AcxStatusMaster acxStatusMaster;
	private AcxUsers acxUsers;
	private String applicantName;
	private String applicantContactNo;
	private String applicantEmail;
	private Date appkicationStatusModifiedOn;
	private String remarks;
	private Set<AcxAdmissionFees> acxAdmissionFeeses = new HashSet<AcxAdmissionFees>(
			0);
	private Set<AcxAdmissionDocuments> acxAdmissionDocumentses = new HashSet<AcxAdmissionDocuments>(
			0);

	public AcxAdmissionInfo() {
	}

	public AcxAdmissionInfo(String applicationId,
			AcxStatusMaster acxStatusMaster, AcxUsers acxUsers,
			String applicantName, String applicantContactNo,
			String applicantEmail) {
		this.applicationId = applicationId;
		this.acxStatusMaster = acxStatusMaster;
		this.acxUsers = acxUsers;
		this.applicantName = applicantName;
		this.applicantContactNo = applicantContactNo;
		this.applicantEmail = applicantEmail;
	}

	public AcxAdmissionInfo(String applicationId,
			AcxStatusMaster acxStatusMaster, AcxUsers acxUsers,
			String applicantName, String applicantContactNo,
			String applicantEmail, Date appkicationStatusModifiedOn,
			String remarks, Set<AcxAdmissionFees> acxAdmissionFeeses,
			Set<AcxAdmissionDocuments> acxAdmissionDocumentses) {
		this.applicationId = applicationId;
		this.acxStatusMaster = acxStatusMaster;
		this.acxUsers = acxUsers;
		this.applicantName = applicantName;
		this.applicantContactNo = applicantContactNo;
		this.applicantEmail = applicantEmail;
		this.appkicationStatusModifiedOn = appkicationStatusModifiedOn;
		this.remarks = remarks;
		this.acxAdmissionFeeses = acxAdmissionFeeses;
		this.acxAdmissionDocumentses = acxAdmissionDocumentses;
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
	public AcxStatusMaster getAcxStatusMaster() {
		return this.acxStatusMaster;
	}

	public void setAcxStatusMaster(AcxStatusMaster acxStatusMaster) {
		this.acxStatusMaster = acxStatusMaster;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "appkication_status_modified_by", nullable = false)
	public AcxUsers getAcxUsers() {
		return this.acxUsers;
	}

	public void setAcxUsers(AcxUsers acxUsers) {
		this.acxUsers = acxUsers;
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
	@Column(name = "appkication_status_modified_on", length = 19)
	public Date getAppkicationStatusModifiedOn() {
		return this.appkicationStatusModifiedOn;
	}

	public void setAppkicationStatusModifiedOn(Date appkicationStatusModifiedOn) {
		this.appkicationStatusModifiedOn = appkicationStatusModifiedOn;
	}

	@Column(name = "remarks")
	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "acxAdmissionInfo")
	public Set<AcxAdmissionFees> getAcxAdmissionFeeses() {
		return this.acxAdmissionFeeses;
	}

	public void setAcxAdmissionFeeses(Set<AcxAdmissionFees> acxAdmissionFeeses) {
		this.acxAdmissionFeeses = acxAdmissionFeeses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "acxAdmissionInfo")
	public Set<AcxAdmissionDocuments> getAcxAdmissionDocumentses() {
		return this.acxAdmissionDocumentses;
	}

	public void setAcxAdmissionDocumentses(
			Set<AcxAdmissionDocuments> acxAdmissionDocumentses) {
		this.acxAdmissionDocumentses = acxAdmissionDocumentses;
	}

}
