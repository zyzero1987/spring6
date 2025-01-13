package com.arvin.spring6.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.arvin.spring6.model.Content;

/**
 * MySQLHibernateConfig class:
 * This class is a configuration class for setting up Hibernate with an MySQL database.
 * It defines beans for the session factory, data source, Hibernate properties, and transaction management.
 * 
 * Key Features:
 * - Configures MySQL database connection.
 * - Defines Hibernate properties for the MySQL database.
 * - Sets up a Hibernate transaction manager for managing transactions.
 * 
 * Author Yu Zhou
 * 
 */
@Configuration
@EnableTransactionManagement // Enables annotation-driven transaction management
public class MySQLHibernateConfig {
	private final static Logger logger = LoggerFactory.getLogger(MySQLHibernateConfig.class);
	
	// Package containing Hibernate entity models
	public static final String MODEL = "com.dsa.oop.model";
	
	// Hibernate configuration property keys
	public static final String DIALECT = "hibernate.dialect";
	public static final String SHOW_SQL = "hibernate.show_sql";
	public static final String FORMAT_SQL = "hibernate.format_sql";
	public static final String SCHEMA_UPDATE = "hibernate.hbm2ddl.auto";
	public static final String DB_COMMENT = "hibernate.use_sql_comments";
	
	@Autowired
	private SystemValueConfig systemValueConfig; // Configuration for database connection values
	
	@Autowired
	private SystemPasswordConfig systemPasswordConfig; // Configuration for sensitive credentials
	
	/**
     * Creates a LocalSessionFactoryBean for Hibernate.
     * This bean is responsible for configuring the Hibernate session factory.
     * 
     * @return a configured LocalSessionFactoryBean instance.
     */
	@Bean(name = Content.MYSQL_SESSION_FACTORY)
    public LocalSessionFactoryBean sessionFactoryMySQL() {
		logger.info("Processing MySQL Session Factory");
		
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSourceMySQL()); // Set the MySQL data source
        sessionFactory.setPackagesToScan(new String[] { MODEL }); // Scan package for entity models
        sessionFactory.setHibernateProperties(hibernatePropertiesMySQL()); // Set Hibernate properties
        return sessionFactory;
    }
	
	/**
     * Creates a DataSource bean for connecting to the MySQL database.
     * This bean configures the database driver, URL, username, and password.
     * 
     * @return a configured DataSource instance.
     */
    @Bean(name = Content.MYSQL_DATA_SOURCE)
    public DataSource dataSourceMySQL() {
    	logger.info("Processing MySQL Data Source");
    	
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(systemValueConfig.getMysql_db_driver_class_name()); // Set driver class
        dataSource.setUrl(systemValueConfig.getMysql_db_jdbc_url()); // Set database URL
        dataSource.setUsername(systemValueConfig.getMysql_db_username()); // Set database username
        dataSource.setPassword(systemPasswordConfig.getMysql_db_password()); // Set database password
        return dataSource;
    }
    
    /**
     * Configures Hibernate properties specific to the MySQL database.
     * These properties include dialect, SQL formatting, and schema management.
     * 
     * @return a Properties object containing Hibernate configuration values.
     */
    private Properties hibernatePropertiesMySQL() {
    	logger.info("Processing MySQL Hibernate Properties");
    	
        Properties properties = new Properties();
        properties.put(DIALECT, systemValueConfig.getMysql_db_dialect()); // Set Hibernate dialect
        properties.put(SHOW_SQL, systemValueConfig.getDb_show_sql()); // Enable/disable SQL logging
        properties.put(FORMAT_SQL, systemValueConfig.getDb_format_sql()); // Enable/disable SQL formatting
        properties.put(SCHEMA_UPDATE, systemValueConfig.getDb_schema_update()); // Configure schema update behavior
        properties.put(DB_COMMENT, systemValueConfig.getDb_use_sql_comments()); // Enable/disable SQL comments
        return properties;
    }
    
    /**
     * Creates a HibernateTransactionManager bean for managing transactions.
     * This transaction manager is linked to the MySQL session factory.
     * 
     * @return a configured HibernateTransactionManager instance.
     */
    @Bean(name = Content.MYSQL_TM)
    public HibernateTransactionManager transactionManagerMySQL() {
    	logger.info("Processing MySQL Transaction Manager");
    	
    	HibernateTransactionManager txManager = new HibernateTransactionManager();
    	txManager.setSessionFactory(sessionFactoryMySQL().getObject()); // Link to session factory
    	return txManager;
    }
}
