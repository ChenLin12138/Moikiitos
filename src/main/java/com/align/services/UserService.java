package com.align.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.align.dao.mappers.UserMapper;
import com.align.dao.mappers.UserRoleMapper;
import com.align.models.Role;
import com.align.models.User;
import com.align.models.UserRole;

/**
 * @author Chen Lin
 * @date 2020-02-09
 */

@Service
public class UserService implements IUserService, UserDetailsService{

	@Autowired
	private UserMapper mapper;
	
	@Autowired
	private UserRoleMapper userRoleMapper;
	
	public User getUserById(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}
	
	public User getUserByEmail(String email) {
		return mapper.selectByEmail(email);
	}
	
	public User getUserByUsername(String username) {
		return mapper.selectByUsername(username);
	}
	
	public void addUser(User user) {
		mapper.insert(user);
	}
	
	public List<Role> getUserRoles(User user) {
		return userRoleMapper.selectRolesByUserId(user.getId());
	}
	
	public void addRole(User user, Role role) {
		UserRole ur = new UserRole();
		ur.setUserId(user.getId());
		ur.setRoleId(role.getId());
		userRoleMapper.insert(ur);
	}
		
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	   
		User user = getUserByUsername(username);
		if(null == user) {
			throw new UsernameNotFoundException("User Not found!");
		}
		user.setRoles(getUserRoles(user));
	
		return user;
	}
}
