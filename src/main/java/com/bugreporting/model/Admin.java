package com.bugreporting.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "AdminDetails")
public class Admin {
	private int adminId;
	private String userName;
	private String password;
	private Roles roles;

	public Admin() {
	}

	public Admin(int adminId, String userName, String password, Roles roles) {
		super();
		this.adminId = adminId;
		this.userName = userName;
		this.password = password;
		this.roles = roles;
	}

	@Id
	@GeneratedValue
	@Column(name = "Admin_Id")
	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	@Column(name = "UserName")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "Password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Role_Id")
	public Roles getRoles() {
		return roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}

}
