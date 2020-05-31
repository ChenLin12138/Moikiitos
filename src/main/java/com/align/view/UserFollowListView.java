package com.align.view;

import java.util.List;

/**
 * @author Chen Lin
 * @date 2020-05-30
 */

public class UserFollowListView {
	
	private Integer userId;

	private List<UserFollowView> followingList;
	
	private List<UserFollowView> followerList;

	public List<UserFollowView> getFollowingList() {
		return followingList;
	}

	public void setFollowingList(List<UserFollowView> followingList) {
		this.followingList = followingList;
	}

	public List<UserFollowView> getFollowerList() {
		return followerList;
	}

	public void setFollowerList(List<UserFollowView> followerList) {
		this.followerList = followerList;
	}
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
}
