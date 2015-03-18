package com.xinov.academix.models;

// Generated Mar 17, 2015 12:04:16 AM by Hibernate Tools 3.4.0.CR1

/**
 * AcxAdmissionDocuments generated by hbm2java
 */
public class AcxAdmissionDocuments implements java.io.Serializable {

	private int id;
	private String acxAdmissionInfoApplicationId;
	private int acxDocumentMasterId;

	public AcxAdmissionDocuments() {
	}

	public AcxAdmissionDocuments(int id, String acxAdmissionInfoApplicationId,
			int acxDocumentMasterId) {
		this.id = id;
		this.acxAdmissionInfoApplicationId = acxAdmissionInfoApplicationId;
		this.acxDocumentMasterId = acxDocumentMasterId;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAcxAdmissionInfoApplicationId() {
		return this.acxAdmissionInfoApplicationId;
	}

	public void setAcxAdmissionInfoApplicationId(
			String acxAdmissionInfoApplicationId) {
		this.acxAdmissionInfoApplicationId = acxAdmissionInfoApplicationId;
	}

	public int getAcxDocumentMasterId() {
		return this.acxDocumentMasterId;
	}

	public void setAcxDocumentMasterId(int acxDocumentMasterId) {
		this.acxDocumentMasterId = acxDocumentMasterId;
	}

}