package com.bugreporting.service;

import java.util.List;

import com.bugreporting.model.Application;
import com.bugreporting.model.Bug;
import com.bugreporting.model.BugAttachment;
import com.bugreporting.model.BugCategory;
import com.bugreporting.model.BugStatus;
import com.bugreporting.model.PriorityLevel;
import com.bugreporting.model.SeverityLevel;

public interface BugService {

	public void saveBugStatus(BugStatus bugStatus);

	public boolean isStatusExists(String bugStatus);

	public boolean isCategoryExists(String bugCategory);

	public void saveCategory(BugCategory bugCategory);

	public boolean isPriorityExists(String priorityName);

	public void savePriority(PriorityLevel priorityLevel);

	public boolean isSeverityExists(String severityName);

	public void saveSeverity(SeverityLevel severityLevel);

	public BugCategory getBugCategoryById(int id);

	public BugStatus getBugStatusById(int id);

	public PriorityLevel getBugPriorityById(int id);

	public SeverityLevel getBugSeverityById(int id);

	public void saveBug(Bug bug);

	public void addAttachment(BugAttachment attachment);

	public Bug getBugById(int bugId);

	public void saveApplication(Application application);

	public Application getAppById(int id);

	public List<Application> getAllApps();

}
