package com.bugreporting.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Assignment")
public class BugAssignment {

	private int assignmentId;
	private Bug bug;
	private User user;

	public BugAssignment() {

	}

	public BugAssignment(int assignmentId, Bug bug, User user) {
		super();
		this.assignmentId = assignmentId;
		this.bug = bug;
		this.user = user;
	}

	@Id
	@GeneratedValue
	@Column(name = "Assignment_Id")
	public int getAssignmentId() {
		return assignmentId;
	}

	public void setAssignmentId(int assignmentId) {
		this.assignmentId = assignmentId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Bug_Id")
	public Bug getBug() {
		return bug;
	}

	public void setBug(Bug bug) {
		this.bug = bug;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "User_Id")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
