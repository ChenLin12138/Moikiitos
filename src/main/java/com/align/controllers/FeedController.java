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
import com.align.view.FeedView;

/**
 * @author Chen Lin
 * @date 2020-02-09
 */

@RestController
@RequestMapping(value = "/v1/moikiitos/feeds")
public class FeedController {
	
	@Autowired
	IFeedService feedService;
	
	
	@RequestMapping(value = "/{userid}", method = RequestMethod.GET)
	public FeedView getLicenses(@PathVariable("userid") Integer userid) {
		User user = new User();
		user.setId(userid);
		List<Feed> feeds = feedService.listFeed(user);
		
		
		return 
	}
}
