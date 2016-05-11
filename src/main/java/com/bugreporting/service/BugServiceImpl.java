package com.bugreporting.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bugreporting.dao.BugDao;
import com.bugreporting.model.Application;
import com.bugreporting.model.Bug;
import com.bugreporting.model.BugAttachment;
import com.bugreporting.model.BugCategory;
import com.bugreporting.model.BugStatus;
import com.bugreporting.model.PriorityLevel;
import com.bugreporting.model.SeverityLevel;

@Service
public class BugServiceImpl implements BugService {
	@Autowired
	private BugDao bugDao;
	private Logger logger = Logger.getLogger(BugServiceImpl.class);

	@Override
	public void saveBugStatus(BugStatus bugStatus) {
		bugDao.saveBugStatus(bugStatus);

	}

	@Override
	public boolean isStatusExists(String bugStatus) {

		return bugDao.isStatusExists(bugStatus);
	}

	@Override
	public boolean isCategoryExists(String bugCategory) {

		return bugDao.isCategoryExists(bugCategory);
	}

	@Override
	public void saveCategory(BugCategory bugCategory) {
		bugDao.saveCategory(bugCategory);

	}

	@Override
	public boolean isPriorityExists(String priorityName) {

		return bugDao.isPriorityExists(priorityName);
	}

	@Override
	public void savePriority(PriorityLevel priorityLevel) {
		bugDao.savePriority(priorityLevel);

	}

	@Override
	public boolean isSeverityExists(String severityName) {

		return bugDao.isSeverityExists(severityName);
	}

	@Override
	public void saveSeverity(SeverityLevel severityLevel) {
		bugDao.saveSeverity(severityLevel);

	}

	@Override
	public BugCategory getBugCategoryById(int id) {

		return bugDao.getBugCategoryById(id);
	}

	@Override
	public BugStatus getBugStatusById(int id) {

		return bugDao.getBugStatusById(id);
	}

	@Override
	public PriorityLevel getBugPriorityById(int id) {

		return bugDao.getBugPriorityById(id);
	}

	@Override
	public SeverityLevel getBugSeverityById(int id) {

		return bugDao.getBugSeverityById(id);
	}

	@Override
	public void saveBug(Bug bug) {
		bugDao.saveBug(bug);

	}

	@Override
	public void addAttachment(BugAttachment attachment) {
		bugDao.addAttachment(attachment);

	}

	@Override
	public Bug getBugById(int bugId) {

		return bugDao.getBugById(bugId);
	}

	@Override
	public void saveApplication(Application application) {
		bugDao.saveApplication(application);

	}

	@Override
	public Application getAppById(int id) {

		return bugDao.getAppById(id);
	}

	@Override
	public List<Application> getAllApps() {

		return bugDao.getAllApps();
	}

}
