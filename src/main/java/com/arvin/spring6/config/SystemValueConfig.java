package com.arvin.spring6.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.arvin.spring6.model.Content;

@Configuration
@PropertySource(value = { Content.CLASS_PATH + Content.APP_PROPERTIES_PATH })
public class SystemValueConfig {
	@Value("${env}")
    private String env = "";
	
	/**************************** MySQL ****************************/
	@Value("${mysql.jdbc.driverClassName}")
	private String mysql_db_driver_class_name = "";
	
	@Value("${mysql.jdbc.url}")
	private String mysql_db_jdbc_url = "";
	
	@Value("${mysql.jdbc.username}")
	private String mysql_db_username = "";
	
	@Value("${hibernate.dialect.mysql}")
	private String mysql_db_dialect = "";
	
	/**************************** MSSQL ****************************/
	@Value("${mssql.jdbc.driverClassName}")
	private String mssql_db_driver_class_name = "";
	
	@Value("${mssql.jdbc.url}")
	private String mssql_db_jdbc_url = "";
	
	@Value("${mssql.jdbc.username}")
	private String mssql_db_username = "";
	
	@Value("${hibernate.dialect.mssql}")
	private String mssql_db_dialect = "";
	
	/**************************** Hibernate ****************************/
	@Value("${hibernate.schema_update}")
	private String db_schema_update = "";
	
	@Value("${hibernate.use_sql_comments}")
	private String db_use_sql_comments = "";
	
	@Value("${hibernate.show_sql}")
	private String db_show_sql = "";
	
	@Value("${hibernate.format_sql}")
	private String db_format_sql = "";

	public String getEnv() {
		return env;
	}

	public void setEnv(String env) {
		this.env = env;
	}

	public String getMysql_db_driver_class_name() {
		return mysql_db_driver_class_name;
	}

	public void setMysql_db_driver_class_name(String mysql_db_driver_class_name) {
		this.mysql_db_driver_class_name = mysql_db_driver_class_name;
	}

	public String getMysql_db_jdbc_url() {
		return mysql_db_jdbc_url;
	}

	public void setMysql_db_jdbc_url(String mysql_db_jdbc_url) {
		this.mysql_db_jdbc_url = mysql_db_jdbc_url;
	}

	public String getMysql_db_username() {
		return mysql_db_username;
	}

	public void setMysql_db_username(String mysql_db_username) {
		this.mysql_db_username = mysql_db_username;
	}

	public String getMysql_db_dialect() {
		return mysql_db_dialect;
	}

	public void setMysql_db_dialect(String mysql_db_dialect) {
		this.mysql_db_dialect = mysql_db_dialect;
	}

	public String getDb_schema_update() {
		return db_schema_update;
	}

	public void setDb_schema_update(String db_schema_update) {
		this.db_schema_update = db_schema_update;
	}

	public String getDb_use_sql_comments() {
		return db_use_sql_comments;
	}

	public void setDb_use_sql_comments(String db_use_sql_comments) {
		this.db_use_sql_comments = db_use_sql_comments;
	}

	public String getDb_show_sql() {
		return db_show_sql;
	}

	public void setDb_show_sql(String db_show_sql) {
		this.db_show_sql = db_show_sql;
	}

	public String getDb_format_sql() {
		return db_format_sql;
	}

	public void setDb_format_sql(String db_format_sql) {
		this.db_format_sql = db_format_sql;
	}

	public String getMssql_db_driver_class_name() {
		return mssql_db_driver_class_name;
	}

	public void setMssql_db_driver_class_name(String mssql_db_driver_class_name) {
		this.mssql_db_driver_class_name = mssql_db_driver_class_name;
	}

	public String getMssql_db_jdbc_url() {
		return mssql_db_jdbc_url;
	}

	public void setMssql_db_jdbc_url(String mssql_db_jdbc_url) {
		this.mssql_db_jdbc_url = mssql_db_jdbc_url;
	}

	public String getMssql_db_username() {
		return mssql_db_username;
	}

	public void setMssql_db_username(String mssql_db_username) {
		this.mssql_db_username = mssql_db_username;
	}

	public String getMssql_db_dialect() {
		return mssql_db_dialect;
	}

	public void setMssql_db_dialect(String mssql_db_dialect) {
		this.mssql_db_dialect = mssql_db_dialect;
	}
}
