package com.bugreporting.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "BugStatus")
public class BugStatus {
	private int bugStatusId;
	private String bugStatusName;
	private Set<Bug> bug2;

	public BugStatus() {

	}

	public BugStatus(int bugStatusId, String bugStatusName, Set<Bug> bug2) {
		super();
		this.bugStatusId = bugStatusId;
		this.bugStatusName = bugStatusName;
		this.bug2 = bug2;
	}

	@Id
	@GeneratedValue
	@Column(name = "BugStatus_Id")
	public int getBugStatusId() {
		return bugStatusId;
	}

	public void setBugStatusId(int bugStatusId) {
		this.bugStatusId = bugStatusId;
	}

	@Column(name = "BugStatus_Name")
	@NotEmpty
	public String getBugStatusName() {
		return bugStatusName;
	}

	public void setBugStatusName(String bugStatusName) {
		this.bugStatusName = bugStatusName;
	}

	@OneToMany(mappedBy = "busStatus1")
	public Set<Bug> getBug2() {
		return bug2;
	}

	public void setBug2(Set<Bug> bug2) {
		this.bug2 = bug2;
	}

}
