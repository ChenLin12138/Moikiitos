package com.align.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.align.models.Feed;
import com.align.models.User;
import com.align.services.IFeedService;
import com.align.services.IFollowService;
import com.align.services.IUserService;
import com.align.view.FeedView;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author Chen Lin
 * @date 2020-02-09
 */

@Api(tags="FeedController")
@RestController
@RequestMapping(value = "/v1/moikiitos/feeds")
public class FeedController {
	
	@Autowired
	IFeedService feedService;
	
	@Autowired
	IUserService userService;
	
	@Autowired
	IFollowService followService;
	
	@ApiOperation(value = "获取Feed信息" ,  notes="通过organizationId和licenseId获取指定的License信息，默认使用Feign方式")
	@RequestMapping(value = "/{userid}", method = RequestMethod.GET)
	public FeedView getFeed(@PathVariable("userid") Integer userid) {
		User user = new User();
		user.setId(userid);
		List<Feed> feeds = feedService.listFeed(user);
		FeedView result = new FeedView();
		result.setFeeds(feeds);
		
		result.setFollowersCount(followService.countFollower(user));
		result.setFollowingCount(followService.countFollowing(user));
		
		String username = userService.getUserById(userid).getName();
		result.setUserName(username);
		return result;
	}
}
