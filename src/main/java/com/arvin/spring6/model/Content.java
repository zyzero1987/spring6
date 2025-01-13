package com.arvin.spring6.model;

public class Content {
	/****************************System Value******************************************/
	public static final String TRUE = "true";
	public static final String FALSE = "false";
	public static final String QUESTION = "?";
	public static final String AND = "&";
	public static final String EQUAL = "=";
	public static final String ENV = "env";
	public static final String POINT = ".";
	public static final String FORWARD_SLASH = "/";
	public static final String EMPTY_ARRAY = "[]";
	public static final String FORMAT = "_format";
	public static final String JSON = "json";
	public static final String HALJSON = "hal_json";
	public static final String LINE_BREAK = "line.separator";
	
	public static final String DOMAIN_LOCAL = "http://localhost:8080";
	public static final String DOMAIN_DEV = "https://edm-dev.ncsu.edu";
	public static final String DOMAIN_PROD = "https://edm.ncsu.edu";
	
	public static final String PROJECT_NAME = "oop";
	
	/****************************System Configuration**********************************/
	public static final int PORT = 3128;
	public static final String STR_PORT = "3128";
	public static final String PROD_PATH = "139.182.75.5";
	
	public static final String SYSTEM_PACKAGES = "com.arvin.spring6";
	
	public static final String LOCAL = "local";
	public static final String DEV = "dev";
	public static final String PROD = "prod";
	public static final String TEST = "test";
	
	public static final String DESTROY_METHOD = "shutdown";
	public static final int THEAD_POOL = 25;
	
	/****************************System AppInitializer**********************************/
	public static final String SERVER_BASE_PATH = "/var/www/files/";
	public static final String LOCAL_BASE_PATH = "C://Users/004306704/";
	public static final String CLASS_PATH = "classpath:";
	public static final String APP_PROPERTIES_PATH = "application.properties";
	public static final String PWD_PROPERTIES_PATH = "password.properties";
	
	/****************************System Hibernate MySQL App Configuration**********************************/
	public static final String MYSQL_SESSION_FACTORY = "sessionFactoryMySQL";
	public static final String MYSQL_DATA_SOURCE = "dataSourceMySQL";
	public static final String MYSQL_TM = "transactionManagerMySQL";
	
	/****************************System Hibernate MSSQL App Configuration**********************************/
	public static final String MSSQL_SESSION_FACTORY = "sessionFactoryMSSQL";
	public static final String MSSQL_DATA_SOURCE = "dataSourceMSSQL";
	public static final String MSSQL_TM = "transactionManagerMSSQL";
	
	/****************************System Security**********************************/
	public static final String AUTH_PATH = "/rest/v1/**";
	public static final String ALLOW_PATH = "/**";
	
	/****************************Rest Bean**********************************/
	public static final int TIME_OUT = 60*60*1000;
	public static final String AUTH_TYPE = "Authorization";
	public static final String AUTH_MODO_MESSAGE_TOKEN = "Token ";
	public static final String AUTH_BASIC = "Basic ";
	public static final String AUTH_BEARER = "Bearer ";
	
	/****************************OnBase**********************************/
	public static final String LOGIN_USER = "valid-user";
	public static final String UID = "uid";
	public static final String DISPLAY_NAME = "displayName";
	
	/****************************File**********************************/
	public static final String DOWNLOAD_PRO_PATH = "https://oop/dsadoors.com/" + PROJECT_NAME + "/resources/";
	public static final String FILE_BASE_PRO_PATH = "/var/www/files/";
	
	/****************************Date Format**********************************/
	public static final int DAY = 1000 * 60 * 60 * 24;
	public static final String TIME_ZOON_LOS_ANGELES ="America/Los_Angeles";
	public static final String yyyy_MM_dd_hh_mm_a = "yyyy-MM-dd hh:mm a";
	public static final String yyyy_MM_dd_HH_mm_ss_X = "yyyy-MM-dd'T'HH:mm:ssX";
	public static final String yyyy_MM_dd_T_HH_mm_ss = "yyyy-MM-dd'T'HH:mm:ss";
	public static final String yyyy_MM_dd_T_HH_mm = "yyyy-MM-dd'T'HH:mm";
	public static final String yyyy_MM_dd_T_HH_mm_ss_XXX = "yyyy-MM-dd'T'HH:mm:ssXXX";
	public static final String yyyy_MM_dd_T_HH_mm_ss_SSS_Z = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
	public static final String yyyy_MM_dd_HH_mm_ss_S = "yyyy-MM-dd HH:mm:ss.S";
	public static final String yyyy_MM_dd_hh_mm_ss = "yyyy-MM-dd hh:mm:ss";
	public static final String yyyy_MM_dd_HH_mm_ss = "yyyy-MM-dd HH:mm:ss";
	public static final String MM_dd_yyyy_HH_mm_ss = "MM/dd/yyyy HH:mm:ss";
	public static final String yyy_MM_dd = "yyyy-MM-dd";
	public static final String EEE_MMMM_dd_yyyy_hh_mm_a = "EEE, MMMM dd, yyyy hh:mm a";
	public static final String EEE_MMMM_dd_h_mm_a = "EEE, MMMM dd, h:mm a";
	public static final String MM_dd_yyyy = "MM/dd/yyyy";
	public static final String MM_yyyy = "MM/yyyy";
	public static final String yyyy = "yyyy";
	public static final String MMMM = "MMMM";
	public static final String dd = "dd";
	public static final String h_mm_a = "h:mm a";
	public static final String hh_mm_a = "hh:mm a";
	public static final String hh_mm = "hh:mm";
	public static final String HH_mm = "HH:mm";
	public static final Long ONE_DAY = (long) (1000 * 60 * 60 * 24);
	public static final String DEFAULT_TIME_START = "00:00:01";
	public static final String DEFAULT_TIME_END = "23:59:59";
	
	/****************************Slock**********************************/
	public static final String EMOJI_EXCLAMATION= ":exclamation:";
	public static final String EMOJI_INFO = ":information_source:";
}
