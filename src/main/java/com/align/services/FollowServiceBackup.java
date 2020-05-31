package com.align.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.align.dao.mappers.FollowRelationshipMapper;
import com.align.models.FollowRelationship;
import com.align.models.User;

/**
 * @author Chen Lin
 * @date 2020-02-08
 */

@Service
public class FollowServiceBackup implements IFollowService{

	@Autowired
	FollowRelationshipMapper mapper;
	
	/*
	 * user1 follow user 2
	 * @param User1
	 * @param User2
	 * */
	public void follow(User user1, User user2){
		
		FollowRelationship record = new FollowRelationship();
		record.setUserid(user1.getId());
		record.setFollowid(user2.getId());
		mapper.insert(record);
	}
	
	/*
	 * user1 unfollow user 2
	 * @param User1
	 * @param User2
	 * */
	public void unfollow(User user1, User user2){
		
		FollowRelationship record = new FollowRelationship();
		record.setUserid(user1.getId());
		record.setFollowid(user2.getId());
		mapper.deleteRecord(record);
	}
	
	/*
	 * Method to get user list follow input user
	 *  @param user a user
	 * 	@return the list who follow the input user
	 * */
	public List<FollowRelationship> getFollowersList(User user){
		
		FollowRelationship record = new FollowRelationship();
		record.setFollowid(user.getId());
		return mapper.selectByFollowId(record);
		
	}
		
	/*
	 * Method to get user list who is followed by input user
	 *  @param user a user
	 * 	@return the list who is followed by input user
	 * */
	public List<FollowRelationship> getFollowingList (User user){
		FollowRelationship record = new FollowRelationship();
		record.setUserid(user.getId());
		return mapper.selectByUserId(record);
	}
	
	public int countFollower(User user) {
		FollowRelationship record = new FollowRelationship();
		record.setFollowid(user.getId());
		return mapper.countByFollowId(record);
	}
	
	public int countFollowing(User user) {
		FollowRelationship record = new FollowRelationship();
		record.setUserid(user.getId());
		return mapper.countByUserId(record);
	}

}
