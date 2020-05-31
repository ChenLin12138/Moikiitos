package com.align.services.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.align.models.FollowRelationship;
import com.align.models.User;
import com.align.models.UserFollow;
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
		
		
		UserFollow follow0 = new UserFollow();
		follow0.setUserid(900000000);
		follow0.setFollowid(900000003);
		
		UserFollow follow1 = new UserFollow();
		follow1.setUserid(900000001);
		follow1.setFollowid(999999999);
		
		UserFollow follow2 = new UserFollow();
		follow2.setUserid(900000002);
		follow2.setFollowid(999999999);
		
		UserFollow follow3 = new UserFollow();
		follow3.setUserid(900000000);
		follow3.setFollowid(999999999);
		
		service.follow(follow0);
		service.follow(follow1);
		service.follow(follow2);
		service.follow(follow3);
		
		
//		service.follow(user1, superStar);
//		service.follow(user2, superStar);
//		service.follow(user0, user3);
		
		userService.addUser(user0);
		userService.addUser(user1);
		userService.addUser(user2);
		userService.addUser(user3);
		userService.addUser(superStar);
		
	}
	
	@Test
	public void getFollowersListTest() {
		
		List<UserFollow> list = service.getFollowersList(superStar);		
		Assert.assertTrue(3==list.size());
	}	
	
	
	@Test
	public void getFollowingListTest() {
		
		List<UserFollow> list = service.getFollowingList(user0);	
		Assert.assertTrue(2==list.size());
	}	
	
	@Test
	public void countFollowerTest() {
		System.out.println(service.countFollower(superStar));
		Assert.assertTrue(3==service.countFollower(superStar));
	}
	
	@Test
	public void countFollowingTest() {
		System.out.println(service.countFollowing(user0));
		Assert.assertTrue(2==service.countFollowing(user0));
	}
	
	@Test
	public void unFollowTest() {
		List<UserFollow> list = service.getFollowersList(superStar);
		service.unfollow(service.getUserFollow(900000000, 999999999).getId());	
		list = service.getFollowersList(superStar);
		Assert.assertTrue(2==list.size());
	}
}
