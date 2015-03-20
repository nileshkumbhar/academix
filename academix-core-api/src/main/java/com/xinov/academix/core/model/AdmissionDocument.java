package com.xinov.academix.core.model;

// Generated Mar 18, 2015 5:31:53 PM by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * AdmissionDocuments generated by hbm2java
 */
@Entity
@Table(name = "acx_admission_documents")
public class AdmissionDocument implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8730906018505871141L;
	
	private int id;
	private AdmissionInfo admissionInfo;
	private DocumentMaster documentMaster;

	public AdmissionDocument() {
	}

	public AdmissionDocument(int id, AdmissionInfo admissionInfo,
			DocumentMaster documentMaster) {
		this.id = id;
		this.admissionInfo = admissionInfo;
		this.documentMaster = documentMaster;
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
	@JoinColumn(name = "_ADMISSION_INFO_application_id", nullable = false)
	public AdmissionInfo getAdmissionInfo() {
		return this.admissionInfo;
	}

	public void setAdmissionInfo(AdmissionInfo admissionInfo) {
		this.admissionInfo = admissionInfo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "_DOCUMENT_MASTER_id", nullable = false)
	public DocumentMaster getDocumentMaster() {
		return this.documentMaster;
	}

	public void setDocumentMaster(DocumentMaster documentMaster) {
		this.documentMaster = documentMaster;
	}

}
