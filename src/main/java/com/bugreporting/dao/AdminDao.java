package com.bugreporting.dao;

import com.bugreporting.model.Admin;

public interface AdminDao {

	public void saveAdmin(Admin admin);

	public Admin getUserByUserName(String userName);

}
