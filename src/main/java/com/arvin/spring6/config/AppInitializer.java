package com.arvin.spring6.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.arvin.spring6.model.Content;

/**
 * AppInitializer class:
 * This class serves as the entry point for configuring and initializing the Spring MVC application.
 * It replaces the traditional `web.xml` file (Servlet 3.0+ applications can use this approach).
 * 
 * It sets up the DispatcherServlet, root application context, and web application context.
 * 
 * Author Yu Zhou
 * 
 */
public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{
	private final static Logger logger = LoggerFactory.getLogger(AppInitializer.class);
	
	public static final String NO_HANDLER = "throwExceptionIfNoHandlerFound";
	
	/**
     * Specifies the configuration classes for the root application context.
     * The root context typically contains service, repository, and business logic beans.
     * 
     * @return an array of configuration classes for the root context.
     */
	@Override
    protected Class<?>[] getRootConfigClasses() {
		logger.info("Processing Root Config");
		
    	return new Class[] { AppConfig.class };
    }
  
	/**
     * Specifies the configuration classes for the web application context.
     * The web context typically contains controllers, view resolvers, and other web-specific beans.
     * 
     * @return an array of configuration classes for the web context.
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
    	logger.info("Processing Servlet Config");
    	
    	return null;
    }
  
    /**
     * Specifies the URL pattern(s) that the DispatcherServlet will handle.
     * For example, "/" indicates the servlet will handle all requests in the application.
     * 
     * @return an array of URL mappings for the DispatcherServlet.
     */
    @Override
    protected String[] getServletMappings() {
    	logger.info("Processing Servlet Mapping");
    	
        return new String[] { Content.FORWARD_SLASH };
    }
}
