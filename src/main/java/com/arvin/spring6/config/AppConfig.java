package com.arvin.spring6.config;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.arvin.spring6.model.Content;

/**
 * AppConfig class:
 * This configuration class is responsible for setting up the Spring MVC application context.
 * It acts as a replacement for the traditional XML-based configuration.
 * 
 * Author Yu Zhou
 * 
 */
@Configuration
@EnableWebMvc // Enables Spring MVC and its default configurations
@ComponentScan(basePackages = Content.SYSTEM_PACKAGES) // Scans the specified package for @Component, @Controller, @Service, etc.
public class AppConfig implements WebMvcConfigurer, SchedulingConfigurer{
	private final static Logger logger = LoggerFactory.getLogger(AppConfig.class);
	
	public static final String DESTROY_METHOD = "shutdown";
	public static final String PREFIX = "/WEB-INF/views/";
	public static final String SUFFIX = ".jsp";
	public static final String RESOURCE_HANDLER = "/resources/**";
	public static final String RESOURCE_LOCATIONS = "/resources/";
	
	/**
     * Configures the view resolver for rendering views.
     * This resolver maps logical view names to actual JSP files in the /WEB-INF/views/ directory.
     * 
     * @return ViewResolver object for resolving JSP views.
     */
	@Bean
    public ViewResolver viewResolver() {
		logger.info("Processing View Resolver");
		
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix(PREFIX);
        viewResolver.setSuffix(SUFFIX);
 
        return viewResolver;
    }
	
	/**
     * Configures the resource handlers for serving static resources like CSS, JavaScript, and images.
     * This allows Spring to map URLs to static resource directories in the project.
     * 
     * @param registry ResourceHandlerRegistry to add resource handlers.
     */
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		logger.info("Processing Resource Handler");
		
        registry.addResourceHandler(RESOURCE_HANDLER).addResourceLocations(RESOURCE_LOCATIONS);
    }
	
	/*
	 * Spring Timer Task
	 */
	@Bean(destroyMethod = Content.DESTROY_METHOD)
    public Executor taskExecutor() {
		logger.info("Processing Task Executor");
		
        return Executors.newScheduledThreadPool(Content.THEAD_POOL);
    }

	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		logger.info("Processing Configure Task");
		
		taskRegistrar.setScheduler(taskExecutor());
	}
}
