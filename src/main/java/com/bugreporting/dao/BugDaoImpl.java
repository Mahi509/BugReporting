package com.bugreporting.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bugreporting.model.Application;
import com.bugreporting.model.Bug;
import com.bugreporting.model.BugAttachment;
import com.bugreporting.model.BugCategory;
import com.bugreporting.model.BugStatus;
import com.bugreporting.model.PriorityLevel;
import com.bugreporting.model.SeverityLevel;

@Repository
@Transactional
public class BugDaoImpl implements BugDao {
	private Logger logger = Logger.getLogger(BugDaoImpl.class);
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveBugStatus(BugStatus bugStatus) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(bugStatus);

	}

	@Override
	public boolean isStatusExists(String bugStatus) {
		try {
			Session session = sessionFactory.getCurrentSession();
			BugStatus bgStatus = (BugStatus) session.createQuery(
					"from BugStatus where bugStatusName='" + bugStatus + "'")
					.uniqueResult();
			if (bgStatus != null) {
				return true;
			}
			return false;

		} catch (RuntimeException e) {
			throw e;
		}
	}

	@Override
	public boolean isCategoryExists(String bugCategory) {
		try {
			Session session = sessionFactory.getCurrentSession();
			BugCategory bgCategory = (BugCategory) session
					.createQuery(
							"from BugCategory where categoryName='"
									+ bugCategory + "'").uniqueResult();
			if (bgCategory != null) {
				return true;
			}
			return false;

		} catch (RuntimeException e) {
			throw e;
		}

	}

	@Override
	public void saveCategory(BugCategory bugCategory) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(bugCategory);

	}

	@Override
	public boolean isPriorityExists(String priorityName) {
		try {
			Session session = sessionFactory.getCurrentSession();
			PriorityLevel prLevel = (PriorityLevel) session.createQuery(
					"from PriorityLevel where priorityName='" + priorityName
							+ "'").uniqueResult();
			if (prLevel != null) {
				return true;
			}
			return false;

		} catch (RuntimeException e) {
			throw e;
		}

	}

	@Override
	public void savePriority(PriorityLevel priorityLevel) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(priorityLevel);

	}

	@Override
	public boolean isSeverityExists(String severityName) {
		try {
			Session session = sessionFactory.getCurrentSession();
			SeverityLevel svLevel = (SeverityLevel) session.createQuery(
					"from SeverityLevel where severityName='" + severityName
							+ "'").uniqueResult();
			if (svLevel != null) {
				return true;
			}
			return false;

		} catch (RuntimeException e) {
			throw e;
		}

	}

	@Override
	public void saveSeverity(SeverityLevel severityLevel) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(severityLevel);

	}

	@Override
	public BugCategory getBugCategoryById(int id) {
		Session session = sessionFactory.getCurrentSession();
		BugCategory bgCategory = (BugCategory) session.get(BugCategory.class,
				id);
		return bgCategory;
	}

	@Override
	public BugStatus getBugStatusById(int id) {
		Session session = sessionFactory.getCurrentSession();
		BugStatus bgStstus = (BugStatus) session.get(BugStatus.class, id);

		return bgStstus;

	}

	@Override
	public PriorityLevel getBugPriorityById(int id) {
		Session session = sessionFactory.getCurrentSession();
		PriorityLevel priority = (PriorityLevel) session.get(
				PriorityLevel.class, id);
		return priority;

	}

	@Override
	public SeverityLevel getBugSeverityById(int id) {
		Session session = sessionFactory.getCurrentSession();
		SeverityLevel severity = (SeverityLevel) session.get(
				SeverityLevel.class, id);
		return severity;

	}

	@Override
	public void saveBug(Bug bug) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(bug);

	}

	@Override
	public void addAttachment(BugAttachment attachment) {
		try {
			sessionFactory.getCurrentSession().persist(attachment);
			logger.debug("persist successful");
		} catch (RuntimeException re) {
			logger.error("persist failed", re);
			throw re;
		}

	}

	@Override
	public Bug getBugById(int bugId) {
		Bug bug = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			bug = (Bug) session.get(Bug.class, bugId);
		} catch (ObjectNotFoundException oe) {
			throw oe;
		}
		return bug;
	}

	@Override
	public void saveApplication(Application application) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.saveOrUpdate(application);
			logger.debug("save successful");
		} catch (RuntimeException re) {
			logger.error("save failed", re);
			throw re;
		}

	}

	@Override
	public Application getAppById(int id) {
		Application application = null;
		Session session = sessionFactory.getCurrentSession();
		try {
			application = (Application) session.get(Application.class, id);

		} catch (ObjectNotFoundException oe) {
			throw oe;

		}

		return application;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Application> getAllApps() {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Application.class);
		List<Application> appList = criteria.list();
		if (appList != null) {
			for (Application app : appList) {
				logger.info("App Names are" + app.getApplicationName());
			}
			return appList;
		} else {
			throw new ObjectNotFoundException(session, null);
		}

	}
}
