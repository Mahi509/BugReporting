package com.bugreporting.extra;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

public class CustomUserAuthenticationFailureHandler extends
SimpleUrlAuthenticationFailureHandler {
	private Logger logger = Logger
			.getLogger(CustomUserAuthenticationFailureHandler.class);

	public void onAuthenticateFailure(HttpServletRequest request,
			HttpServletResponse response, AuthenticationException exception)
			throws IOException, ServletException {
		logger.info("<------------Inside Authentication Failure----------->");
		super.onAuthenticationFailure(request, response, exception);

	}

}
