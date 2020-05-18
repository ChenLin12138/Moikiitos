package com.align.services.test;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.align.dao.mappers.RoleMapper;
import com.align.models.Role;
import com.align.services.RoleService;

/**
 * @author Chen Lin
 * @date 2020-05-17
 */

public class RoleServiceTest extends BaseServiceTest {

	@Autowired
	private RoleService service;
	
	@Test
//	@Rollback(false)
	public void insert () {
		Role role = new Role();
		role.setRole("test");
		Assert.assertTrue(1==service.insert(role));
	}
	
	@Test
	public void selectByPrimaryKey() {
		Role role = service.getRoleById(1);
		Assert.assertTrue("ROLE_admin".equals(role.getRole()));
		
	}
	
	
}
