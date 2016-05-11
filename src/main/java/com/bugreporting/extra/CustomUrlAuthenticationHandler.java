package com.bugreporting.extra;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

public class CustomUrlAuthenticationHandler extends
		SimpleUrlAuthenticationSuccessHandler {
	private Logger logger = Logger
			.getLogger(CustomUrlAuthenticationHandler.class);

	public void onAuthenticateSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication) {
	
		logger.info("<------Authentication Success------->");
		clearAuthenticationAttributes(request);
	}

}