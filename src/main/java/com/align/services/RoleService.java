package com.align.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.align.dao.mappers.RoleMapper;
import com.align.models.Role;

/**
 * @author Chen Lin
 * @date 2020-05-19
 */

@Service
public class RoleService {
	
	@Autowired
	RoleMapper mapper;
	
	public int insert(Role role) {
		return mapper.insert(role);
	}
	
	public Role getRoleById(int id) {
		return mapper.selectByPrimaryKey(id);
	}
	
}
