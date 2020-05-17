package com.align.services.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.align.dao.mappers.RoleMapper;
import com.align.models.Role;

/**
 * @author Chen Lin
 * @date 2020-05-17
 */

public class RoleServiceTest extends BaseServiceTest {

	@Autowired
	private RoleMapper roleMapper;
	
	@Test
	@Rollback(false)
	public void insert () {
		Role role = new Role();
		role.setDesc("test");
		roleMapper.insert(role);
	}
}
