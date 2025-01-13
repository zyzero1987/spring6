package com.arvin.spring6.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.arvin.spring6.dao.UserDao;
import com.arvin.spring6.model.Content;
import com.arvin.spring6.model.User;
import com.arvin.spring6.payload.PageRequest;
import com.arvin.spring6.payload.PageResult;

/**
 * Implementation of the UserDao interface using Hibernate and MySQL.
 * This class handles CRUD operations and queries for User entities.
 * 
 * Author Yu Zhou
 * 
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {
	// Logger for logging information and errors within DAO methods
	private final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
	
	// Injects the MySQL SessionFactory bean to interact with the database
	@Autowired
	@Qualifier(Content.MYSQL_SESSION_FACTORY)
	private SessionFactory sessionFactoryMySQL;
	
	/**
     * Saves a new User or updates an existing User record in the database.
     *
     * @param model the User entity to be saved or updated.
     * @return true if the operation was successful, false otherwise.
     */
	@Override
	public boolean saveUpdateUser(User model) {
		logger.info("Processing DB saveUpdateUser -> " + model.getUsername() + ", and the provider -> " + model.getProvider());
		boolean result = true;
		try {
			// Attempt to save or update the user entity
			if(model.getUser_id() == 0) {
				this.sessionFactoryMySQL.getCurrentSession().persist(model);
			}else {
				this.sessionFactoryMySQL.getCurrentSession().merge(model);
			}
		}catch(Exception ex) {
			logger.error("Error cause by the saveUpdateUser -> " + ex.getMessage());
			result = false;
			ex.printStackTrace();
		}
		return result;
	}

	/**
     * Finds and returns a User by its unique ID.
     *
     * @param id the unique identifier of the User.
     * @return the User entity if found, or null if not found or on error.
     */
	@Override
	@SuppressWarnings({ "unchecked", "deprecation" })
	public User findUserById(int id) {
		logger.info("Processing DB findUserById -> " + id);
		
		List<User> list = new ArrayList<User>();
		
		String sql = "FROM User where id=:id"; // HQL query to find user by id
		
		try {
			Query<User> query = sessionFactoryMySQL.getCurrentSession().createQuery(sql);
            query.setParameter("id", id);
            list.addAll(query.getResultList());
		}catch(Exception ex) {
			logger.error("Error cause by the findUserById -> " + ex.getMessage());
			ex.printStackTrace();
		}
		
		// Return the user if exactly one result was found
		if(list.size() > 0 && list.size() == 1) {
			return list.get(0);
		}else {
			return null;
		}
	}

	/**
     * Finds and returns a User by its username.
     *
     * @param username the username to search for.
     * @return the User entity if found, or null if not found or on error.
     */
	@Override
	@SuppressWarnings({ "unchecked", "deprecation" })
	public User findUserByUsername(String username) {
		logger.info("Processing DB findUserByUsername -> " + username);
		
		List<User> list = new ArrayList<User>();
		
		String sql = "FROM User where username=:username"; // HQL query to find user by username
		
		try {
			Query<User> query = sessionFactoryMySQL.getCurrentSession().createQuery(sql);
            query.setParameter("username", username);
            list.addAll(query.list());
		}catch(Exception ex) {
			logger.error("Error cause by the findUserByUsername -> " + ex.getMessage());
			ex.printStackTrace();
		}
		
		// Return the user if exactly one result was found
		if(list.size() > 0 && list.size() == 1) {
			return list.get(0);
		}else {
			return null;
		}
	}

	/**
     * Finds and returns a User by its email address.
     *
     * @param email the email address to search for.
     * @return the User entity if found, or null if not found or on error.
     */
	@Override
	@SuppressWarnings({ "unchecked", "deprecation" })
	public User findUserByEmail(String email) {
		logger.info("Processing DB findUserByEmail -> " + email);
		
		List<User> list = new ArrayList<User>();
		
		String sql = "FROM User where email=:email"; // HQL query to find user by email
		
		try {
			Query<User> query = sessionFactoryMySQL.getCurrentSession().createQuery(sql);
            query.setParameter("email", email);
            list.addAll(query.list());
		}catch(Exception ex) {
			logger.error("Error cause by the findUserByEmail -> " + ex.getMessage());
			ex.printStackTrace();
		}
		
		// Return the user if exactly one result was found
		if(list.size() > 0 && list.size() == 1) {
			return list.get(0);
		}else {
			return null;
		}
	}

	/**
     * Searches for Users whose usernames contain the specified substring.
     *
     * @param username the substring to search within usernames.
     * @return a list of User entities matching the search criteria.
     */
	@Override
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<User> findUserByUsernameSearch(String username) {
		logger.info("Processing DB findUserByUsernameSearch -> " + username);
		
		List<User> list = new ArrayList<User>();
		
		// HQL query using LIKE operator for partial matching of username
		String sql = "FROM User where username like :username";
		
		try {
			Query<User> query = sessionFactoryMySQL.getCurrentSession().createQuery(sql);
            query.setParameter("username", "%" + username + "%");
            list.addAll(query.list());
		}catch(Exception ex) {
			logger.error("Error cause by the findUserByUsernameSearch -> " + ex.getMessage());
			ex.printStackTrace();
		}
		
		return list;
	}

	/**
     * Retrieves a paginated list of Users based on the provided PageRequest.
     *
     * @param request the pagination request parameters including page index.
     * @return a PageResult containing the list of Users and pagination details.
     */
	@Override
	@SuppressWarnings({ "unchecked", "deprecation" })
	public PageResult<User> getUserByPage(PageRequest request) {
		logger.info("Processing DB getUserByPage -> " + request.getIndex());
		
		String sql = "";
		Query<User> query = null;
		
		PageResult<User> result = new PageResult<User>();
		
		result.setIndex(request.getIndex()); // Set current page index
		
		try {
			// First query to count total number of User records
			sql = "select count(*) from User";
			query = this.sessionFactoryMySQL.getCurrentSession().createQuery(sql);
			result.setTotalRecords(Integer.parseInt(query.uniqueResult().toString()));
			
			 // Second query to fetch a page of User results ordered by username descending
			sql = "from User u ORDER BY u.username DESC";
			query = this.sessionFactoryMySQL.getCurrentSession().createQuery(sql);
			query.setFirstResult(result.getStart()); // Set starting index for pagination
	        query.setMaxResults(result.getPageSize()); // Set maximum number of records to retrieve

			result.setResults(query.list());
		}catch(Exception ex) {
			logger.error("Error cause by the getUserByPage -> " + ex.getMessage());
			ex.printStackTrace();
		}
		return result;
	}

	/**
     * Deletes the specified User from the database.
     *
     * @param model the User entity to be deleted.
     * @return true if the deletion was successful, false otherwise.
     */
	@Override
	public boolean deleteUser(User model) {
		logger.info("Processing DB deleteUser -> " + model.getUsername());
		boolean result = true;
		try {
			this.sessionFactoryMySQL.getCurrentSession().remove(model);
		}catch(Exception ex) {
			logger.error("Error cause by the deleteUser -> " + ex.getMessage());
			result = false;
			ex.printStackTrace();
		}
		return result;
	}
}
