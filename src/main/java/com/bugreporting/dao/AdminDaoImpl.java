package com.bugreporting.dao;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bugreporting.model.Admin;

@Repository
@Transactional
public class AdminDaoImpl implements AdminDao {
	@Autowired
	private SessionFactory sessionFactory;
	private Logger logger = Logger.getLogger(AdminDaoImpl.class);

	@Override
	public void saveAdmin(Admin admin) {
		Session session = sessionFactory.getCurrentSession();
		String password = admin.getPassword();
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		admin.setPassword(encoder.encode(password));
		session.saveOrUpdate(admin);

	}

	@Override
	public Admin getUserByUserName(String userName) {
		try {
			logger.debug("fetching admin by name");
			Session session = sessionFactory.getCurrentSession();
			Query query = (Query) session
					.createQuery("from Admin where userName='" + userName + "'");
			Admin adminInfo = (Admin) query.uniqueResult();
			return adminInfo;
		} catch (RuntimeException re) {
			throw re;
		}
	}

}
