package com.bugreporting.service;

import com.bugreporting.model.Admin;

public interface AdminService {

	public void saveAdmin(Admin admin);

	public Admin getUserByUserName(String userName);

}
