package com.align.view;

/**
 * @author Chen Lin
 * @date 2020-05-31
 */

public class UserFollowView {

	private Integer id;

	private Integer userId;

	private Integer followId;
	
	private String followName;
	
	private String followEmail;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getFollowId() {
		return followId;
	}

	public void setFollowId(Integer followId) {
		this.followId = followId;
	}


	public String getFollowName() {
		return followName;
	}

	public void setFollowName(String followName) {
		this.followName = followName;
	}

	public String getFollowEmail() {
		return followEmail;
	}

	public void setFollowEmail(String followEmail) {
		this.followEmail = followEmail;
	}

}
