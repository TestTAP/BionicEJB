package com.bionic.movieplex.dao.beans.user;

import java.util.List;

import com.bionic.movieplex.beans.User;

public interface UserDAO {
	public List<User> getAllUsers();

	public void addUser(User user);

	public User updateUser(User user);

	/**
	 * 
	 * @param userLogin
	 * @param userPassword
	 * @return
	 * User obj
	 */
	public User findUserByLoginPassword(String userLogin, String userPassword);

}
