package com.align.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.align.dao.mappers.UserFollowMapper;
import com.align.models.User;
import com.align.models.UserFollow;
import com.align.view.UserFollowView;

/**
 * @author Chen Lin
 * @date 2020-02-08
 */

@Service
public class FollowService{

	@Autowired
	UserFollowMapper mapper;
	
	
	public boolean follow(UserFollow userFollow){
		return 1 == mapper.insert(userFollow);
	}
	
	public boolean unfollow(Integer primaryKey){
		return 1 == mapper.deleteByPrimaryKey(primaryKey);
	}
	
	/*
	 * Method to get user list follow input user
	 *  @param user a user
	 * 	@return the list who follow the input user
	 * */
	public List<UserFollow> getFollowersList(User user){
		return mapper.selectByFollowId(user.getId());
	}
		

	public List<UserFollowView> getFollowersListWithNameAndEmail (User user){
		return mapper.selectByFollowIdWithNameAndEmail(user.getId());
	}
		
	/*
	 * Method to get user list who is followed by input user
	 *  @param user a user
	 * 	@return the list who is followed by input user
	 * */
	public List<UserFollow> getFollowingList (User user){
		return mapper.selectByUserId(user.getId());
	}
	
	public UserFollow getUserFollow (int uid, int fid){
		return mapper.selectByUserIdAndFollowId(uid,fid);
	}
	
	public List<UserFollowView> getFollowingListWithNameAndEmail(User user){
		return mapper.selectByUserIdWithNameAndEmail(user.getId());
	}
	
	
	public int countFollower(User user) {
		return mapper.countByFollowId(user.getId());
	}
	
	public int countFollowing(User user) {
		return mapper.countByUserId(user.getId());
	}

}
