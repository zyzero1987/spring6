package com.arvin.spring6.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * SecurityApplicationInitializer is responsible for initializing the Spring Security
 * configuration in a web application. It extends AbstractSecurityWebApplicationInitializer,
 * which automatically registers the Spring Security filter chain for the application.
 * 
 * <p>This initializer ensures that the Spring Security framework is integrated and
 * configured before the application starts handling requests.</p>
 * 
 * Author Yu Zhou
 * 
 */
public class SecurityApplicationInitializer extends AbstractSecurityWebApplicationInitializer{
	// Logger for logging initialization events
	private final static Logger logger = LoggerFactory.getLogger(SecurityApplicationInitializer.class);
	
	// Static block executed when the class is loaded. Used here to log initialization.
	static{
		logger.info("Processing Security Application Initializer");
	}
}
