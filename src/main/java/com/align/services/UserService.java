package com.align.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	
	public List<User> getUserByEmailLike(String email) {
		return mapper.selectByEmailLike("%"+email+"%");
	}
	
	public User getUserByUsername(String username) {
		return mapper.selectByUsername(username);
	}
	
	
	public List<User> getUserByUsernameLike(String username) {
		return mapper.selectByUsernameLike("%"+username+"%");
	}
	
	public boolean addUser(User user) {
		
		user.setEnabled(true);
		user.setAccountNonExpired(true);
		user.setAccountNonLocked(true);
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String password = encoder.encode(user.getPassword());
		user.setPassword(password);
		
		int userInsertResult = mapper.insert(user);
		return userInsertResult ==1;

	}
	
	public boolean registerUser(User user) {
		user.setEnabled(true);
		user.setAccountNonExpired(true);
		user.setAccountNonLocked(true);
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String password = encoder.encode(user.getPassword());
		user.setPassword(password);
		
		int userInsertResult = mapper.insert(user);
		
		user = mapper.selectByUsername(user.getUsername());
		Role role = new Role();
		role.setId(2);
		int roleInsertResult = addRole(user, role);
		return userInsertResult ==1 && roleInsertResult == 1;
	}
	
	public List<Role> getUserRoles(User user) {
		return userRoleMapper.selectRolesByUserId(user.getId());
	}
	
	public int addRole(User user, Role role) {
		UserRole ur = new UserRole();
		ur.setUserId(user.getId());
		ur.setRoleId(role.getId());
		return userRoleMapper.insert(ur);
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
