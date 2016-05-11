package com.bugreporting.extra;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bugreporting.service.AdminService;

@Service("customUserDetailsService")
@Transactional(readOnly = true)
public class CustomUserDetailService implements UserDetailsService {
	@Resource(name = "adminService")
	private AdminService adminService;
	private Logger logger = Logger.getLogger(CustomUserDetailService.class);

	@Override
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		logger.info("In customservice load UserName");
		UserDetails user = null;
		try {
			com.bugreporting.model.Admin adminInfo = adminService
					.getUserByUserName(userName);
			user = new User(adminInfo.getUserName(), adminInfo.getPassword(),
					true, true, true, true, getAuthorities(adminInfo.getRoles()
							.getRoleId()));
			logger.info("role id is" + user.getAuthorities().toString());
			logger.info("role" + adminInfo.getRoles().getRoleId());

		} catch (Exception ex) {
			logger.error("Error in retrieving admin", ex);
			throw new UsernameNotFoundException("Error in retrieving admin");
		}

		return user;
	}

	public Collection<GrantedAuthority> getAuthorities(Integer roleId) {

		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
		if (roleId.compareTo(1) == 0) {
			authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
			logger.info("Grant ROLE_ADMIN to this user");
		}

		return authList;

	}

}
