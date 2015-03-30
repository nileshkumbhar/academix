package com.xinov.academix.core.api.domain;

import java.io.Serializable;
import java.util.Date;

public class Document implements Serializable {

	private static final long serialVersionUID = 6488839146800880646L;

	private long id;
	private String documentName;
	private String documentPath;
	private User createdBy;
	private Date createdDate;
	private User modifiedBy;
	private Date modifiedDate;
	
	public Document() {
		super();
	}

	public Document(long id, String documentName, String documentPath,
			User createdBy, Date createdDate) {
		super();
		this.id = id;
		this.documentName = documentName;
		this.documentPath = documentPath;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public String getDocumentPath() {
		return documentPath;
	}

	public void setDocumentPath(String documentPath) {
		this.documentPath = documentPath;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public User getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(User modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	
}
