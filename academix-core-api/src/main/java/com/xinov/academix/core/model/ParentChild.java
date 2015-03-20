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
 * ParentChild generated by hbm2java
 */
@Entity
@Table(name = "acx_parent_child")
public class ParentChild implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6939467214792249173L;
	
	private int id;
	private User parent;
	private User child;

	public ParentChild() {
	}

	public ParentChild(int id, User parent,
			User child) {
		this.id = id;
		this.parent = parent;
		this.child = child;
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
	@JoinColumn(name = "parent_id", nullable = false)
	public User getParent() {
		return this.parent;
	}

	public void setParent(User parent) {
		this.parent = parent;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "child_id", nullable = false)
	public User getChild() {
		return this.child;
	}

	public void setChild(User child) {
		this.child = child;
	}

}
