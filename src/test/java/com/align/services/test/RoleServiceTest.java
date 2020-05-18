package com.align.services.test;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.align.dao.mappers.RoleMapper;
import com.align.models.Role;

/**
 * @author Chen Lin
 * @date 2020-05-17
 */

public class RoleServiceTest extends BaseServiceTest {

	@Autowired
	private RoleMapper roleMapper;
	
//	@Autowired
//	private RoleService service;
	
	@Test
//	@Rollback(false)
	public void insert () {
		Role role = new Role();
		role.setRole("test");
		roleMapper.insert(role);
		Assert.assertTrue(1==roleMapper.insert(role));
	}
	
	@Test
	public void selectByPrimaryKey() {
		Role role = roleMapper.selectByPrimaryKey(1);
		Assert.assertTrue("ROLE_admin".equals(role.getRole()));
		
	}
	
	
}
