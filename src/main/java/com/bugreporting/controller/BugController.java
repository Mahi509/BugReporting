package com.bugreporting.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bugreporting.constants.Platform;
import com.bugreporting.model.Application;
import com.bugreporting.model.Bug;
import com.bugreporting.model.BugCategory;
import com.bugreporting.model.BugStatus;
import com.bugreporting.model.PriorityLevel;
import com.bugreporting.model.SeverityLevel;
import com.bugreporting.service.BugService;

@RestController
@RequestMapping(value = "/bug")
public class BugController {
	@Autowired
	private BugService bugService;
	private Logger logger = Logger.getLogger(BugController.class);

	/*
	 * @RequestMapping(value = "/") public String getHome() {
	 * logger.info("In home"); return "home"; }
	 */

	/* method to save bug status */
	@RequestMapping(value = "/saveBugStatus", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> saveBugStatus(
			@Validated @RequestBody BugStatus bugStatus) {

		if (bugStatus.getBugStatusName() != null
				&& bugStatus.getBugStatusName() != "") {

			if (bugService.isStatusExists(bugStatus.getBugStatusName())) {
				logger.info("BugStatus name with name" + "  "
						+ bugStatus.getBugStatusName() + "  "
						+ "already exists");
				return new ResponseEntity<Void>(HttpStatus.CONFLICT);

			} else {
				bugService.saveBugStatus(bugStatus);
			}

		} else {
			logger.info("Enter proper name");
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);

		}

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	/* method to save bug category */
	@RequestMapping(value = "/saveBugCategory", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> saveBugCategory(
			@Validated @RequestBody BugCategory bugCategory) {
		logger.info("Invoking save category method");
		if (bugService.isCategoryExists(bugCategory.getCategoryName())) {
			logger.info("BugCategory name with name" + "  "
					+ bugCategory.getCategoryName() + "  " + "already exists");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);

		} else {
			bugService.saveCategory(bugCategory);

		}

		return new ResponseEntity<Void>(HttpStatus.OK);

	}

	/* method to save bug priority levels */
	@RequestMapping(value = "/saveBugPriority", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> saveBugPriority(
			@Validated @RequestBody PriorityLevel level) {
		logger.info("Invoking save priority method");
		if (bugService.isPriorityExists(level.getPriorityName())) {
			logger.info("BugPriority name with name" + "  "
					+ level.getPriorityName() + "  " + "already exists");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);

		} else {
			bugService.savePriority(level);

		}

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	/* method to save bug severity levels */
	@RequestMapping(value = "/saveBugSeverity", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> saveBugSeverity(
			@Validated @RequestBody SeverityLevel severityLevel) {
		logger.info("Invoking save severity method");
		if (bugService.isSeverityExists(severityLevel.getSeverityName())) {
			logger.info("BugSeverity name with name" + "  "
					+ severityLevel.getSeverityName() + "  " + "already exists");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);

		} else {
			bugService.saveSeverity(severityLevel);
		}

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	/* method to save bug details */
	@RequestMapping(value = "/saveBug", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> saveBugDetails(@Validated @RequestBody Bug bug) {
		logger.info("In Bug save method");
		BugCategory bgCategory = null;
		BugStatus bgStatus = null;
		PriorityLevel prLevel = null;
		SeverityLevel srLevel = null;
		Application application = null;

		bgCategory = bugService.getBugCategoryById(bug.getBugCategory1()
				.getBugCategoryId());
		bug.setBugCategory1(bgCategory);
		bgStatus = bugService.getBugStatusById(bug.getBusStatus1()
				.getBugStatusId());
		bug.setBusStatus1(bgStatus);
		prLevel = bugService.getBugPriorityById(bug.getPriorityLevel1()
				.getpriorityLevelId());
		bug.setPriorityLevel1(prLevel);
		srLevel = bugService.getBugSeverityById(bug.getSeverityLevel1()
				.getSeverityLevelId());
		bug.setSeverityLevel1(srLevel);

		application = bugService.getAppById(bug.getApplication().getAppId());
		if (application != null) {
			bug.setApplication(application);

		} else {
			logger.info("App Id " + " " + bug.getApplication().getAppId()
					+ "  " + "not found");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		Platform pf = Platform.valueOf(bug.getPlatform());
		bug.setPlatform(pf.getStatusValue());
		bugService.saveBug(bug);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	/*
	 * @RequestMapping(value = "/attachment", method = RequestMethod.POST,
	 * headers = "content-type=multipart/form-data") public ResponseEntity<Void>
	 * addImage(@RequestParam("bugId") int bugId,
	 * 
	 * @RequestParam("file") MultipartFile imageFile) {
	 * logger.info("Inside add attachment"); Bug bug = null; BugAttachment
	 * attachment = null; InputStream inputStream = null; byte[] bytes = null;
	 * MultipartFile mfile = ((BugAttachment) imageFile).getImageFile(); try {
	 * inputStream = mfile.getInputStream(); bytes =
	 * IOUtils.toByteArray(inputStream); logger.info("image has bytes::" +
	 * bytes); attachment = new BugAttachment(); attachment.setImage(bytes);
	 * 
	 * } catch (IOException e) { e.printStackTrace();
	 * 
	 * } bug = bugService.getBugById(bugId); attachment.setBug1(bug);
	 * bugService.addAttachment(attachment);
	 * 
	 * return new ResponseEntity<Void>(HttpStatus.OK);
	 * 
	 * }
	 */
	@RequestMapping(value = "/saveApplication", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> saveApplicationDetails(
			@RequestBody Application application) {
		logger.info("In save Application method");
		/*
		 * Platform[] p = Platform.values(); for (Platform p1 : p) {
		 * logger.info("Platform values are" + p1.getStatusValue()); }
		 */
		Platform platform = Platform.valueOf(application.getPlatform()
				.toUpperCase());
		logger.info(Platform.valueOf(application.getPlatform()));
		logger.info(platform.getStatusValue());
		application.setPlatform(platform.getStatusValue());

		// application.setPlatform(Platform.getEnumVals(application.getPlatform()));
		bugService.saveApplication(application);
		return new ResponseEntity<Void>(HttpStatus.OK);

	}

	@RequestMapping(value = "/getApps")
	public ResponseEntity<List<Application>> getAllApps() {
		List<Application> appsList = null;
		appsList = bugService.getAllApps();
		if (appsList.isEmpty()) {
			return new ResponseEntity<List<Application>>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<List<Application>>(appsList, HttpStatus.OK);

	}

}
