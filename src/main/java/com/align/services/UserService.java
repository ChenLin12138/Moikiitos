package com.align.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.align.dao.mappers.UserMapper;
import com.align.models.User;

/**
 * @author Chen Lin
 * @date 2020-02-09
 */

@Service
public class UserService implements IUserService, UserDetailsService{

	@Autowired
	private UserMapper mapper;
	
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

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
//	   User user = hrMapper.loadUserByUsername(username);
//        if (hr == null) {
//            throw new UsernameNotFoundException("用户名不存在!");
//        }
//        hr.setRoles(hrMapper.getHrRolesById(hr.getId()));
//        return hr;
		
		return null;
	}
}
