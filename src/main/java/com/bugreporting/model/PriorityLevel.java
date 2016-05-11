package com.bugreporting.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "PriorityLevel")
public class PriorityLevel {

	private int priorityLevelId;
	private String priorityName;
	private Set<Bug> bug1;

	public PriorityLevel() {

	}

	public PriorityLevel(int priorityLevelId, String priorityName) {
		super();
		this.priorityLevelId = priorityLevelId;
		this.priorityName = priorityName;
	}

	@Id
	@GeneratedValue
	@Column(name = "PriorityLevel_Id")
	public int getpriorityLevelId() {
		return priorityLevelId;
	}

	public void setpriorityLevelId(int priorityLevelId) {
		this.priorityLevelId = priorityLevelId;
	}

	@Column(name = "Priority_Name")
	@NotBlank
	public String getPriorityName() {
		return priorityName;
	}

	public void setpriorityName(String priorityName) {
		this.priorityName = priorityName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "priorityLevel1")
	public Set<Bug> getBug1() {
		return bug1;
	}

	public void setBug1(Set<Bug> bug1) {
		this.bug1 = bug1;
	}

}
