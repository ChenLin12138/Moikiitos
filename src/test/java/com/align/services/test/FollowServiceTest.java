package com.align.services.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.align.models.FollowRelationship;
import com.align.models.User;
import com.align.services.FollowService;

/**
 * @author Chen Lin
 * @date 2020-02-08
 */

public class FollowServiceTest extends BaseServiceTest{

	@Autowired
	private FollowService service;
	
	
	User superStar = new User();
	User user0 = new User();
	User user1 = new User();
	User user2 = new User();
	User user3 = new User();

	@Before
	public void setup() {
		
		superStar.setId(999999999);
		superStar.setEmail("superStar@Test.com");
		superStar.setName("superStar");
		superStar.setPassword("124");
		
		user0.setId(900000000);
		user0.setEmail("testFollowinguser@Test.com");
		user0.setName("following");
		user0.setPassword("134");
		
		user1.setId(900000001);
		user1.setEmail("testFollowinguser@Test.com");
		user1.setName("following");
		user1.setPassword("134");
		
		user2.setId(900000002);
		user2.setEmail("testFollowinguser@Test.com");
		user2.setName("following");
		user2.setPassword("134");
		
		user3.setId(900000003);
		user3.setEmail("testFollowinguser@Test.com");
		user3.setName("following");
		user3.setPassword("134");
		
		service.follow(user0, superStar);
		service.follow(user1, superStar);
		service.follow(user2, superStar);
		service.follow(user0, user3);
		
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
