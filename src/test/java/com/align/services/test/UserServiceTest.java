package com.align.services.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.align.dao.mappers.UserMapper;
import com.align.models.FollowRelationship;
import com.align.models.User;

/**
 * @author Chen Lin
 * @date 2020-02-09
 */

public class UserServiceTest extends BaseServiceTest {

	@Autowired
	private UserMapper mapper;
	
	User user0 = new User();
	
	@Before
	public void setup() {
		user0.setId(900000000);
		user0.setEmail("user0@Test.com");
		user0.setName("user0");
		user0.setPassword("134");
		
		mapper.insert(user0);
	
	}
	
	@Test
	public void getUserByIdTest() {
		Assert.assertTrue("user0".equals(mapper.selectUserById(900000000).getName()));
	}
	
	
	@Test
	public void getUserByEmailTest() {
		Assert.assertTrue("user0".equals(mapper.selectUserByemail("user0@Test.com").getName()));
	}
	
	
	
}
