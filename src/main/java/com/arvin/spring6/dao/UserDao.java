package com.arvin.spring6.dao;

import java.util.List;

import com.arvin.spring6.model.User;
import com.arvin.spring6.payload.PageRequest;
import com.arvin.spring6.payload.PageResult;

/**
 * UserDao interface:
 * This interface defines the data access methods for managing `User` entities in the application.
 * It provides CRUD operations and additional query methods to handle user data in the database.
 * 
 * Author Yu Zhou
 * 
 */
public interface UserDao {
	/**
     * Saves or updates a user in the database.
     * 
     * @param model the `User` entity to be saved or updated.
     * @return true if the operation was successful, false otherwise.
     */
	public boolean saveUpdateUser(User model);
	
	/**
     * Finds a user in the database by their unique ID.
     * 
     * @param id the unique identifier of the user.
     * @return the `User` entity with the specified ID, or null if not found.
     */
	public User findUserById(int id);
	
	/**
     * Finds a user in the database by their username.
     * 
     * @param username the username of the user.
     * @return the `User` entity with the specified username, or null if not found.
     */
	public User findUserByUsername(String username);
	
	/**
     * Finds a user in the database by their email address.
     * 
     * @param email the email address of the user.
     * @return the `User` entity with the specified email, or null if not found.
     */
	public User findUserByEmail(String email);
	
	/**
     * Searches for users whose usernames match or partially match the given input.
     * 
     * @param username the partial or full username to search for.
     * @return a list of `User` entities matching the search criteria.
     */
	public List<User> findUserByUsernameSearch(String username);
	
	 /**
     * Retrieves a paginated list of users from the database.
     * 
     * @param request a `PageRequest` object containing pagination and sorting information.
     * @return a `PageResult` containing the paginated list of users and additional metadata.
     */
	public PageResult<User> getUserByPage(PageRequest request);
	
	/**
     * Deletes a user from the database.
     * 
     * @param model the `User` entity to be deleted.
     * @return true if the operation was successful, false otherwise.
     */
	public boolean deleteUser(User model);
}
