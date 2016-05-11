package com.bugreporting.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ApplicationDetails")
public class Application {

	private int appId;
	private String applicationName;
	private String platform;
	private Set<Bug> bug;

	public Application() {

	}

	public Application(int appId, String applicationName, String platform,
			Set<Bug> bug) {
		super();
		this.appId = appId;
		this.applicationName = applicationName;
		this.platform = platform;
		this.bug = bug;
	}

	@Id
	@GeneratedValue
	@Column(name = "AppId")
	public int getAppId() {
		return appId;
	}

	public void setAppId(int appId) {
		this.appId = appId;
	}

	@Column(name = "ApplicationName")
	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	@Column(name = "Platform")
	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	@OneToMany(mappedBy = "application",fetch=FetchType.LAZY)
	@JsonIgnore
	public Set<Bug> getBug() {
		return bug;
	}

	public void setBug(Set<Bug> bug) {
		this.bug = bug;
	}

	/*
	 * public Platform getPlatform1() { return platform1; }
	 * 
	 * public void setPlatform1(Platform platform1) { this.platform1 =
	 * platform1; }
	 */

	/*
	 * public Application(int appId, String applicationName, Platform platform)
	 * { super(); this.appId = appId; this.applicationName = applicationName;
	 * this.platform = platform; }
	 */

}
