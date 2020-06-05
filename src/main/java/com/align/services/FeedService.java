package com.align.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.align.dao.mappers.FeedMapper;
import com.align.models.Feed;
import com.align.models.User;
import com.align.models.UserFollow;

/**
 * @author Chen Lin
 * @date 2020-02-08
 */

@Service
public class FeedService implements IFeedService{

	@Autowired
	FeedMapper mapper;
	
	@Autowired
	FollowService followService;
	
	/*
	 * Post Feed
	 * @param feed
	 * */
	public boolean postFeed(Feed feed){
		
		return (1 == mapper.insert(feed));
	}
	
	/*
	 * List Feed
	 * @return List of feed which User is follow
	 * */
	public List<Feed> listFeed(User user){
		
		List<Integer> ids = new ArrayList<Integer>();
		
		ids.add(user.getId());
		
		for(UserFollow followRelationship : followService.getFollowingList(user)) {
			ids.add(followRelationship.getFollowid());
		}
		
		List<Feed> usersFeeds = mapper.selectFeedByUsersId(ids);
		
		return usersFeeds;
	}
	
	public Feed listFeedById(Feed feed) {
		return mapper.selectByPrimaryKey(feed.getId());
	}
	
}
