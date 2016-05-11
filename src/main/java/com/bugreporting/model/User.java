package com.bugreporting.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "UserInfo")
public class User {

	private int userId;
	private String name;
	/* private String password; */
	private Set<BugAssignment> bugAssignment;

	public User() {

	}

	public User(int userId, String name, Set<BugAssignment> bugAssignment) {
		super();
		this.userId = userId;
		this.bugAssignment = bugAssignment;
		this.name = name;
		/* this.password = password; */
	}

	@Id
	@GeneratedValue
	@Column(name = "User_Id")
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<BugAssignment> getBugAssignment() {
		return bugAssignment;
	}

	public void setBugAssignment(Set<BugAssignment> bugAssignment) {
		this.bugAssignment = bugAssignment;
	}

	@Column(name = "Name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*
	 * @Column(name = "password") public String getPassword() { return password;
	 * }
	 * 
	 * public void setPassword(String password) { this.password = password; }
	 */

}
