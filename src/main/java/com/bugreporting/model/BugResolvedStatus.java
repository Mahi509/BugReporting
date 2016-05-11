/*package com.bugreporting.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BugResolvedStatus")
public class BugResolvedStatus {

	private int resolvedStatusId;
	private String resolvedStatusName;

	public BugResolvedStatus() {
	}

	public BugResolvedStatus(int resolvedStatusId, String resolvedStatusName) {
		super();
		this.resolvedStatusId = resolvedStatusId;
		this.resolvedStatusName = resolvedStatusName;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ResolvedStatus_Id")
	public int getResolvedStatusId() {
		return resolvedStatusId;
	}

	public void setResolvedStatusId(int resolvedStatusId) {
		this.resolvedStatusId = resolvedStatusId;
	}

	@Column(name = "ResolvedStatus_Name")
	public String getResolvedStatusName() {
		return resolvedStatusName;
	}

	public void setResolvedStatusName(String resolvedStatusName) {
		this.resolvedStatusName = resolvedStatusName;
	}

}
*/