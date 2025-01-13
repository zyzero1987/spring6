package com.arvin.spring6.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.arvin.spring6.model.Content;

@Configuration
@PropertySource(value = { Content.CLASS_PATH + Content.PWD_PROPERTIES_PATH })
public class SystemPasswordConfig {
	/**************************** MySQL ****************************/
	@Value("${mysql.jdbc.password}")
	private String mysql_db_password = "";
	
	/**************************** MSSQL ****************************/
	@Value("${mssql.jdbc.password}")
	private String mssql_db_password = "";

	public String getMysql_db_password() {
		return mysql_db_password;
	}

	public void setMysql_db_password(String mysql_db_password) {
		this.mysql_db_password = mysql_db_password;
	}

	public String getMssql_db_password() {
		return mssql_db_password;
	}

	public void setMssql_db_password(String mssql_db_password) {
		this.mssql_db_password = mssql_db_password;
	}
}
