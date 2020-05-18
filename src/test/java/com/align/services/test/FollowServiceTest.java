package com.align.services.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.align.models.FollowRelationship;
import com.align.models.User;
import com.align.services.FollowService;
import com.align.services.UserService;

/**
 * @author Chen Lin
 * @date 2020-02-08
 */

public class FollowServiceTest extends BaseServiceTest{

	@Autowired
	private FollowService service;
	
	@Autowired
	private UserService userService;
	
	
	User superStar = new User();
	User user0 = new User();
	User user1 = new User();
	User user2 = new User();
	User user3 = new User();

	@Before
	public void setup() {
		
		superStar.setId(999999999);
		superStar.setEmail("superStar@Test.com");
		superStar.setUsername("superStar");
		superStar.setPassword("124");
		superStar.setAccountNonLocked(true);
		superStar.setAccountNonExpired(true);
		superStar.setEnabled(true);
		
		user0.setId(900000000);
		user0.setEmail("user0@Test.com");
		user0.setUsername("user0");
		user0.setPassword("134");
		user0.setAccountNonLocked(true);
		user0.setAccountNonExpired(true);
		user0.setEnabled(true);
		
		user1.setId(900000001);
		user1.setEmail("user1@Test.com");
		user1.setUsername("user1");
		user1.setPassword("134");
		user1.setAccountNonLocked(true);
		user1.setAccountNonExpired(true);
		user1.setEnabled(true);
		
		user2.setId(900000002);
		user2.setEmail("user2@Test.com");
		user2.setUsername("user2");
		user2.setPassword("134");
		user2.setAccountNonLocked(true);
		user2.setAccountNonExpired(true);
		user2.setEnabled(true);
		
		user3.setId(900000003);
		user3.setEmail("user3@Test.com");
		user3.setUsername("user3");
		user3.setPassword("134");
		user3.setAccountNonLocked(true);
		user3.setAccountNonExpired(true);
		user3.setEnabled(true);
		
		service.follow(user0, superStar);
		service.follow(user1, superStar);
		service.follow(user2, superStar);
		service.follow(user0, user3);
		
		userService.addUser(user0);
		userService.addUser(user1);
		userService.addUser(user2);
		userService.addUser(user3);
		userService.addUser(superStar);
		
	}
	
	@Test
	public void getFollowersListTest() {
		
		List<FollowRelationship> list = service.getFollowersList(superStar);		
		Assert.assertTrue(list.contains(new FollowRelationship(900000000,999999999)));
		Assert.assertTrue(list.contains(new FollowRelationship(900000001,999999999)));
		Assert.assertTrue(list.contains(new FollowRelationship(900000002,999999999)));
		Assert.assertTrue(!list.contains(new FollowRelationship(900000003,999999999)));
	}	
	
	
	@Test
	public void getFollowingListTest() {
		
		List<FollowRelationship> list = service.getFollowingList(user0);	
		Assert.assertTrue(list.contains(new FollowRelationship(900000000,999999999)));
		Assert.assertTrue(list.contains(new FollowRelationship(900000000,900000003)));
	}	
	
	@Test
	public void countFollowerTest() {
		Assert.assertTrue(3==service.countFollower(superStar));
	}
	
	@Test
	public void countFollowingTest() {
		Assert.assertTrue(2==service.countFollowing(user0));
	}
	
	@Test
	public void unFollowTest() {
		List<FollowRelationship> list = service.getFollowersList(superStar);
		service.unfollow(user0, superStar);	
		list = service.getFollowersList(superStar);
		Assert.assertTrue(!list.contains(new FollowRelationship(900000000,999999999)));
	}
}
