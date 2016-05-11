package com.bugreporting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bugreporting.dao.AdminDao;
import com.bugreporting.model.Admin;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminDao adminDao;

	@Override
	public void saveAdmin(Admin admin) {
		adminDao.saveAdmin(admin);

	}

	@Override
	public Admin getUserByUserName(String userName) {

		return adminDao.getUserByUserName(userName);
	}

}
