package com.bugreporting.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bugreporting.model.Admin;
import com.bugreporting.model.Roles;
import com.bugreporting.service.AdminService;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;
	private Logger logger = Logger.getLogger(AdminController.class);

	@RequestMapping(value = "/saveAdmin", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> saveAdminDetails(@RequestBody Admin admin) {
		logger.info("In save Admin method");
		try {
			if (admin.getUserName() != "" && admin.getUserName() != null
					&& admin.getPassword() != "" && admin.getPassword() != "") {
				Roles roles = new Roles();
				roles.setRoleId(1);
				admin.setRoles(roles);
				adminService.saveAdmin(admin);
				logger.info("Admin saved Successfully");

			} else {
				return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
			}

		} catch (NullPointerException ne) {
			logger.info("null exception" + ne);
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);

		}
		return new ResponseEntity<Void>(HttpStatus.OK);

	}

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String showHello() {
		logger.info("In Hello test");
		return "hello";
	}
}
