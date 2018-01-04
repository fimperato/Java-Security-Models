package it.imperato.service.security.jwt.springboot;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Servlet Initializer
 * 
 */
public class ServletInitializer 
		extends SpringBootServletInitializer 
		{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringBootExampleApplication.class);
	}

}
