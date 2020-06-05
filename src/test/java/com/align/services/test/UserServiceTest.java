package com.align.services.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.align.models.Role;
import com.align.models.User;
import com.align.services.UserService;

/**
 * @author Chen Lin
 * @date 2020-02-09
 */

public class UserServiceTest extends BaseServiceTest {
	
	@Autowired
	private UserService service;
	
	User user0 = new User();
	
	@Before
	public void setup() {
		user0.setId(900000000);
		user0.setEmail("user0@Test.com");
		user0.setUsername("user0");
		user0.setPassword("134");
		user0.setAccountNonLocked(true);
		user0.setAccountNonExpired(true);
		user0.setEnabled(true);
		service.addUser(user0);
			
		Role role0 = new Role();
		role0.setId(1);
		Role role1 = new Role();
		role1.setId(2);
		
		service.addRole(user0, role0);
		service.addRole(user0, role1);
	
	}
	
	@Test
	public void getUserByIdTest() {
		User user = service.getUserById(900000000);
		Assert.assertTrue("user0".equals(user.getUsername()));
		Assert.assertTrue(user.isEnabled());
	}
	
	
	@Test
	public void getUserByEmailTest() {
		Assert.assertTrue("user0".equals(service.getUserByEmail("user0@Test.com").getUsername()));
	}	
	
	@Test
	public void getUserByUsernameTest() {
		Assert.assertTrue("user0@Test.com".equals(service.getUserByUsername("user0").getEmail()));
	}
	
	@Test
	public void getUserRoles() {
		
		List<String> expectedRoles = new ArrayList<String>();
		expectedRoles.add("ROLE_admin");
		expectedRoles.add("ROLE_user");
	
		
		List<String> actualRoles = new ArrayList<String>();
		
		List<Role> roles = service.getUserRoles(user0);
		
		for(Role role : roles) {
			actualRoles.add(role.getRole());
		}	
		assertThat(actualRoles, is(expectedRoles));	
	}
}
