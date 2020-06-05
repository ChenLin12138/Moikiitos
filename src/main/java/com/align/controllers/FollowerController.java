package com.align.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.align.models.FollowRelationship;
import com.align.models.RespBean;
import com.align.models.User;
import com.align.models.UserFollow;
import com.align.services.FollowService;
import com.align.services.IUserService;
import com.align.view.UserFollowListView;
import com.align.view.UserFollowView;

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
	FollowService followService;
	
	@ApiOperation(value = "获取用户关注和关注用户的列表" ,  notes="根据传入的用户id，获取该用户关注和关注该用户的人")
	@RequestMapping(value = "/{userid}", method = RequestMethod.GET)
	public UserFollowListView getFollowList(@PathVariable("userid") Integer userid) {
		
		User user = new User();
		user.setId(userid);
		UserFollowListView result = new UserFollowListView();
		
		List<UserFollowView> followerList = followService.getFollowersListWithNameAndEmail(user);
		result.setFollowerList(followerList);
		
		List<UserFollowView> followingList = followService.getFollowingListWithNameAndEmail(user);		
		result.setFollowingList(followingList);
		result.setUserId(userid);
		
		return result;
	}
	
	@ApiOperation(value = "添加关注" ,  notes="通过用户id组添加关注")
	@RequestMapping(value = "/{userid}", method = RequestMethod.POST)
	public RespBean follow(@RequestBody UserFollow userFollow) {
		boolean success = followService.follow(userFollow);
		
		if(success) {
			return RespBean.ok("关注成功！");
		}else {
			return RespBean.ok("关注失败，请重试！");
		}
	}
	
	@ApiOperation(value = "取消关注" ,  notes="通过用户id组取消关注")
	@RequestMapping(value = "/{userid}", method = RequestMethod.DELETE)
	public RespBean unfollow(@PathVariable("userid") Integer userid) {
		boolean success = followService.unfollow(userid);
		
		if(success) {
			return RespBean.ok("取消关注成功！");
		}else {
			return RespBean.ok("取消关注失败，请重试！");
		}
	}
}
