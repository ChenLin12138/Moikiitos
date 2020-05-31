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
import com.align.models.UserEmail;
import com.align.services.IFollowService;
import com.align.services.IUserService;
import com.align.view.UserFollowListView;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author Chen Lin
 * @date 2020-02-09
 */

@Api(tags="FollowerController")
@RestController
@RequestMapping(value = "/v1/moikiitos/follow")
public class FollowerController {
	
	@Autowired
	IUserService userService;
	
	@Autowired
	IFollowService followService;
	
	@ApiOperation(value = "获取用户关注和关注用户的列表" ,  notes="根据传入的用户id，获取该用户关注和关注该用户的人")
	@RequestMapping(value = "/{userid}", method = RequestMethod.GET)
	public UserFollowListView getFollowList(@PathVariable("userid") Integer userid) {
		
		User user = new User();
		user.setId(userid);
		UserFollowListView result = new UserFollowListView();
		
		List<FollowRelationship> followerList = followService.getFollowersList(user);
		List<UserEmail> followers = new ArrayList<UserEmail> ();
		
		for(FollowRelationship e : followerList) {
			UserEmail follower = new UserEmail();
			follower.setUserId(e.getUserid());
			follower.setUserName(e.getName());
			follower.setEmail(e.getEmail());
			followers.add(follower);
		}
		
		result.setFollowerList(followers);
		
		List<FollowRelationship> followingList = followService.getFollowingList(user);
		List<UserEmail> followings = new ArrayList<UserEmail> ();
		for(FollowRelationship e : followingList) {
			UserEmail following = new UserEmail();
			following.setUserId(e.getFollowid());
			following.setUserName(e.getName());
			following.setEmail(e.getEmail());
			followings.add(following);
		}
		
		result.setFollowingList(followings);
		result.setUserId(userid);
		
		return result;
	}
	
	@ApiOperation(value = "添加关注" ,  notes="通过用户id新添关注")
	@RequestMapping(value = "/{userid}", method = RequestMethod.POST)
	public void follow(@PathVariable("userid") Integer userid) {
		
	}
	
	@ApiOperation(value = "添加关注" ,  notes="通过用户id新添关注")
	@RequestMapping(value = "/{userid}", method = RequestMethod.DELETE)
	public void unfollow(@PathVariable("userid") Integer userid) {
		
	}
}
