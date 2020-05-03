package com.align.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.align.models.FollowRelationship;
import com.align.models.User;
import com.align.services.IFollowService;
import com.align.services.IUserService;
import com.align.view.UserFollowView;

/**
 * @author Chen Lin
 * @date 2020-02-09
 */

@RestController
@RequestMapping(value = "/v1/moikiitos/follows")
public class FollowController {
	
	@Autowired
	IUserService userService;
	
	@Autowired
	IFollowService followService;
	
	
	@RequestMapping(value = "/{userid}", method = RequestMethod.GET)
	public UserFollowView getFeed(@PathVariable("userid") Integer userid) {
		
		User user = new User();
		user.setId(userid);
		UserFollowView result = new UserFollowView();
		
		List<FollowRelationship> followerList = followService.getFollowersList(user);
		List<User> followers = new ArrayList<User> ();
		
		for(FollowRelationship e : followerList) {
			User follower = new User();
			follower.setId(e.getUserid());
			follower.setName(e.getName());
			follower.setEmail(e.getEmail());
			followers.add(follower);
		}
		
		result.setFollowers(followers);
		
		List<FollowRelationship> followingList = followService.getFollowingList(user);
		List<User> followings = new ArrayList<User> ();
		for(FollowRelationship e : followingList) {
			User following = new User();
			following.setId(e.getFollowid());
			following.setName(e.getName());
			following.setEmail(e.getEmail());
			followings.add(following);
		}
		
		result.setFollowing(followings);
		
		result.setFollowersCount(followService.countFollower(user));
		result.setFollowingCount(followService.countFollowing(user));
		
		String username = userService.getUserById(userid).getName();
		result.setUserName(username);
		return result;
	}
	
	@RequestMapping(value = "/search/{keyword}", method = RequestMethod.POST)
	public User searchUser(@PathVariable("keyword") String keyword) {
		return new User();
	}
}
