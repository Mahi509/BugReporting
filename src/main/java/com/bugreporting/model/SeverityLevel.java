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
@Table(name = "SeverityLevel")
public class SeverityLevel {

	private int severityLevelId;
	private String severityName;
	private Set<Bug> bug;

	public SeverityLevel() {

	}

	public SeverityLevel(int severityLevelId, String severityName) {
		super();
		this.severityLevelId = severityLevelId;
		this.severityName = severityName;
	}

	@Id
	@GeneratedValue
	@Column(name = "SeverityLevel_Id")
	public int getSeverityLevelId() {
		return severityLevelId;
	}

	public void setSeverityLevelId(int severityLevelId) {
		this.severityLevelId = severityLevelId;
	}

	@Column(name = "Severity_Name")
	@NotEmpty
	public String getSeverityName() {
		return severityName;
	}

	public void setSeverityName(String severityName) {
		this.severityName = severityName;
	}

	@OneToMany(mappedBy = "severityLevel1")
	public Set<Bug> getBug() {
		return bug;
	}

	public void setBug(Set<Bug> bug) {
		this.bug = bug;
	}
}
