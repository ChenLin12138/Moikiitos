package com.align.services;

import com.align.models.User;

/**
 * @author Chen Lin
 * @date 2020-02-09
 */

public interface IUserService {

	public User getUserById(Integer id);
	
	public User getUserByEmail(String email);
	
	public User getUserByUsername(String username);
	
	public boolean addUser(User user);
}
