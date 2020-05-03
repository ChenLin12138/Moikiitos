package com.align.services.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.align.models.Feed;
import com.align.models.FollowRelationship;
import com.align.models.User;
import com.align.services.FeedService;

/**
 * @author Chen Lin
 * @date 2020-02-08
 */

public class FeedServiceTest extends BaseServiceTest{

	@Autowired
	private FeedService service;
	
	@Test
	public void getFollowersListTest() {
		User user = new User();
		user.setId(1);
		List<Feed> feeds = service.listFeed(user);	
		Assert.assertTrue(3==feeds.size());
	}	
	
	@Test
	public void postFeed() {
		Feed feed = new Feed();
		feed.setId(999999999);
		feed.setContent("I am super star.");
		feed.setUserid(999999999);
		service.postFeed(feed);
		Assert.assertTrue(999999999==service.listFeedById(feed).getId());
	}
}
