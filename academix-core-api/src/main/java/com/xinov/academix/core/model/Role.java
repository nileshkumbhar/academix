package com.xinov.academix.core.model;

// Generated Mar 18, 2015 5:31:53 PM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * RoleMaster generated by hbm2java
 */
@Entity
@Table(name = "acx_role_master", uniqueConstraints = @UniqueConstraint(columnNames = "title"))
public class Role implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2793043549738890430L;
	
	private int id;
	private String title;
	private Set<UserRole> userRoles = new HashSet<UserRole>(0);

	public Role() {
	}

	public Role(int id, String title) {
		this.id = id;
		this.title = title;
	}

	public Role(int id, String title, Set<UserRole> userRoles) {
		this.id = id;
		this.title = title;
		this.userRoles = userRoles;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "title", unique = true, nullable = false, length = 45)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "RoleMaster")
	public Set<UserRole> getUserRoles() {
		return this.userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

}
