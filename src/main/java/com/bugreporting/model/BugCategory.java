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
@Table(name = "BugCategory")
public class BugCategory {

	private int bugCategoryId;
	private String categoryName;
	private Set<Bug> bug;

	public BugCategory(int bugCategoryId, String categoryName) {
		super();
		this.bugCategoryId = bugCategoryId;
		this.categoryName = categoryName;
	}

	public BugCategory() {
	}

	@Id
	@GeneratedValue
	@Column(name = "BugCategory_Id")
	public int getBugCategoryId() {
		return bugCategoryId;
	}

	public void setBugCategoryId(int bugCategoryId) {
		this.bugCategoryId = bugCategoryId;
	}

	@Column(name = "BugCategoryName")
	@NotEmpty
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@OneToMany(mappedBy = "bugCategory1")
	public Set<Bug> getBug() {
		return bug;
	}

	public void setBug(Set<Bug> bug) {
		this.bug = bug;
	}

}
