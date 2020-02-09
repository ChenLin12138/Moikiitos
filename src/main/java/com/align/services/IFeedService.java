package com.align.services;

import java.util.List;

import com.align.models.Feed;
import com.align.models.User;

/**
 * @author Chen Lin
 * @date 2020-02-09
 */

public interface IFeedService {
	/*
	 * Post Feed
	 * @param feed
	 * */
	public void postFeed(Feed feed);
	
	/*
	 * List Feed
	 * @return List of feed which User is follow
	 * */
	public List<Feed> listFeed(User user);
}
