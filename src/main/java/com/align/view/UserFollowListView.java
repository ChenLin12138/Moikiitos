package com.align.view;

import java.util.List;

import com.align.models.UserEmail;

/**
 * @author Chen Lin
 * @date 2020-05-30
 */

public class UserFollowListView {
	
	private Integer userId;
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	private List<UserEmail> followingList;
	
	private List<UserEmail> followerList;

	public List<UserEmail> getFollowingList() {
		return followingList;
	}

	public void setFollowingList(List<UserEmail> followingList) {
		this.followingList = followingList;
	}

	public List<UserEmail> getFollowerList() {
		return followerList;
	}

	public void setFollowerList(List<UserEmail> followerList) {
		this.followerList = followerList;
	}
}
