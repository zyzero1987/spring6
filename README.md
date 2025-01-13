# Spring MVC Application with Google OAuth2 Integration

This project is a pure Spring MVC application built from the ground up without using Spring Boot. It showcases the integration of Google OAuth2 for authentication and adheres to a clean architecture that embraces best practices for maintainability and scalability.

## Key Features

* Pure Spring MVC: No Spring Boot dependencies are used in this project.
* Google OAuth2 Login Integration: Seamless authentication using Google OAuth2.
* Spring Security 6: Provides robust security features.
* Hibernate 6: Handles data persistence with improved performance and new features.
* OpenJDK 22: Utilizes the latest features and performance improvements of Java.
* Tomcat 10: Serves as the application server, compliant with Jakarta EE 9+ specifications, necessary for Spring 6 compatibility.

## Technologies and Dependencies

| Technology | Version |
| --- | --- |
| `Spring Framework` | 6.x |
| `Spring Security` | 6.x |
| `Hibernate` | 6.x |
| `Java (OpenJDK)` | 22 |
| `Tomcat` | 10.x |

## Prerequisites
```
oop/
┣ src/
┃ ┣ main/
┃ ┃ ┣ java/
┃ ┃ ┃ ┗ com/
┃ ┃ ┃   ┗ dsa/
┃ ┃ ┃ ┃   ┗ oop/
┃ ┃ ┃ ┃ ┃   ┣ apiclient/        --Where you should place API client connection objects
┃ ┃ ┃ ┃ ┃   ┣ config/           --Where you should place globle project configuration objects
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ AppConfig.java  --Spring MVC configuration
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ AppInitializer.java        --Spring MVC web client initializer
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ MySQLHibernateConfig.java  --MySQL DB connection configuration
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ SystemPasswordConfig.java  --Project init general password configuration
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ SystemValueConfig.java     --Project init general value configuration
┃ ┃ ┃ ┃ ┃   ┣ controller/       --Where you should place MVC endpoint function
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ IndexController.java       --Spring MVC page endpoint controller
┃ ┃ ┃ ┃ ┃   ┣ dao/              --Where you should place database interface objects
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ impl/           --Where you should place database interface implemented objects
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ UserDaoImpl.java
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ UserDao.java
┃ ┃ ┃ ┃ ┃   ┣ model/            --Where you should place database entity objects
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ Content.java
┃ ┃ ┃ ┃ ┃   ┣ payload/          --Where you should place web request payload objects
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ UserLoginObj.java
┃ ┃ ┃ ┃ ┃   ┣ security/         --Where you should place application security related configuration
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ SecurityApplicationInitializer.java
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ SecurityConfig.java
┃ ┃ ┃ ┃ ┃   ┗ services/         --Where you should place business layer interface objects
┃ ┃ ┃ ┃ ┃ ┃   ┣ impl/           --Where you should place business layer interface implemented objects
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ UserServiceImpl.java
┃ ┃ ┃ ┃ ┃ ┃   ┣ CustomOAuth2UserService.java
┃ ┃ ┃ ┃ ┃ ┃   ┗ UserService.java
┃ ┃ ┣ resources/                --Where you should place application auto configuration property objects
┃ ┃ ┃ ┣ application.properties
┃ ┃ ┃ ┣ logback.xml             --Application log configration
┃ ┃ ┃ ┗ password.properties
┃ ┃ ┗ webapp/                   --Where you should place frontend realted objects
┃ ┃   ┗ WEB-INF/                --Spring MVC web folder
┃ ┃ ┃   ┣ views/                --Spring MVC jsp page folder
┃ ┃ ┃ ┃ ┃ ┗ index.jsp
┃ ┃ ┃   ┗ web.xml
┣ pom.xml                       --Maven project management file
┗ README.md
```

## Configure Application Properties
```
mysql.jdbc.driverClassName = com.mysql.cj.jdbc.Driver
mysql.jdbc.url = jdbc:mysql://localhost:3306/spring6?characterEncoding=utf8&useSSL=false
mysql.jdbc.username = root

hibernate.schema_update = update
hibernate.use_sql_comments = true
hibernate.dialect.mysql = org.hibernate.dialect.MySQL8Dialect

hibernate.c3p0.min_size = 5
hibernate.c3p0.max_size = 20
hibernate.c3p0.acquire_increment = 1
hibernate.c3p0.timeout = 1800
hibernate.c3p0.max_statements = 150

hibernate.show_sql = false
hibernate.format_sql = true

env = local
```

## Configure Password Properties
```
mysql.jdbc.password = 
```

## Build the Project
Use a build tool like Maven or Gradle to compile and package the application:
```
mvn clean package
```

## Deploy to Tomcat
```
* Copy the generated .war file from the target directory.
* Place the .war file in the webapps folder of your Tomcat installation.
* Start Tomcat and access the application at http://localhost:8080/spring6.
```
