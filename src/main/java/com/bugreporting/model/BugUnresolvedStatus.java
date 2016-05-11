/*package com.bugreporting.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BugUnResolvedStatus")
public class BugUnresolvedStatus {
	private int unResolvedStatusId;
	private String unResolvedStatusName;

	public BugUnresolvedStatus() {
	}

	public BugUnresolvedStatus(int unResolvedStatusId,
			String unResolvedStatusName) {
		super();
		this.unResolvedStatusId = unResolvedStatusId;
		this.unResolvedStatusName = unResolvedStatusName;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "UnResolvedStatus_Id")
	public int getUnResolvedStatusId() {
		return unResolvedStatusId;
	}

	public void setUnResolvedStatusId(int unResolvedStatusId) {
		this.unResolvedStatusId = unResolvedStatusId;
	}

	@Column(name = "UnResolvedStatus_Name")
	public String getUnResolvedStatusName() {
		return unResolvedStatusName;
	}

	public void setResolvedStatusName(String unResolvedStatusName) {
		this.unResolvedStatusName = unResolvedStatusName;
	}

}
*/