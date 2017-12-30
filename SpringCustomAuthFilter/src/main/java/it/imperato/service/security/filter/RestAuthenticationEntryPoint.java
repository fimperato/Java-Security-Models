package it.imperato.service.security.filter;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.apache.log4j.Logger;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;


/**
 * This entry point is called once the request missing the authentication but if
 * the request dosn't have the cookie then we send the unauthorized response.
 * 
 */
@Component("restAuthenticationEntryPoint")
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {
	
	private static final Logger log = LoggerFactory.getLogger(RestAuthenticationEntryPoint.class);
	
	@Override
	public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			AuthenticationException authenticationException) throws IOException, ServletException {
		
		log.info("RestAuthenticationEntryPoint.commence()");
		
		httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");

	}

}