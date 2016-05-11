package com.bugreporting.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "BugDetails")
public class Bug {

	private int bugId;
	private Set<BugAssignment> bugAssignment1;
	private PriorityLevel priorityLevel1;
	private SeverityLevel severityLevel1;
	private BugStatus busStatus1;
	private Set<BugAttachment> bugAttachment1;
	private BugCategory bugCategory1;
	private String bugDescription;
	private Application application;
	private String platform;

	public Bug() {

	}

	public Bug(int bugId, Set<BugAssignment> bugAssignment1,
			PriorityLevel priorityLevel1, SeverityLevel severityLevel1,
			BugStatus busStatus1, Set<BugAttachment> bugAttachment1,
			BugCategory bugCategory1, String bugDescription, String platform) {
		super();
		this.bugId = bugId;
		this.bugAssignment1 = bugAssignment1;
		this.priorityLevel1 = priorityLevel1;
		this.severityLevel1 = severityLevel1;
		this.busStatus1 = busStatus1;
		this.bugAttachment1 = bugAttachment1;
		this.bugCategory1 = bugCategory1;
		this.bugDescription = bugDescription;
		this.platform = platform;

	}

	@Id
	@GeneratedValue
	@Column(name = "Bug_Id")
	public int getBugId() {
		return bugId;
	}

	public void setBugId(int bugId) {
		this.bugId = bugId;
	}

	@OneToMany(mappedBy = "bug")
	public Set<BugAssignment> getBugAssignment1() {
		return bugAssignment1;
	}

	public void setBugAssignment1(Set<BugAssignment> bugAssignment1) {
		this.bugAssignment1 = bugAssignment1;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PriorityLevel_Id")
	public PriorityLevel getPriorityLevel1() {
		return priorityLevel1;
	}

	public void setPriorityLevel1(PriorityLevel priorityLevel1) {
		this.priorityLevel1 = priorityLevel1;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "SeverityLevel_Id")
	public SeverityLevel getSeverityLevel1() {
		return severityLevel1;
	}

	public void setSeverityLevel1(SeverityLevel severityLevel1) {
		this.severityLevel1 = severityLevel1;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "BugStatus_Id")
	public BugStatus getBusStatus1() {
		return busStatus1;
	}

	public void setBusStatus1(BugStatus busStatus1) {
		this.busStatus1 = busStatus1;
	}

	@OneToMany(mappedBy = "bug1", cascade = CascadeType.PERSIST)
	public Set<BugAttachment> getBugAttachment1() {
		return bugAttachment1;
	}

	public void setBugAttachment1(Set<BugAttachment> bugAttachment1) {
		this.bugAttachment1 = bugAttachment1;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "BugCategory_Id")
	public BugCategory getBugCategory1() {
		return bugCategory1;
	}

	public void setBugCategory1(BugCategory bugCategory1) {
		this.bugCategory1 = bugCategory1;
	}

	@Column(name = "Bug_Description")
	public String getBugDescription() {
		return bugDescription;
	}

	public void setBugDescription(String bugDescription) {
		this.bugDescription = bugDescription;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "AppId")
	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	@Column(name = "Platform")
	@NotEmpty(message = "Platform is empty")
	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}
}
