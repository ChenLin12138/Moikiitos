//package com.align.services;
//
//import java.util.List;
//
//import com.align.models.FollowRelationship;
//import com.align.models.User;
//import com.align.models.UserFollow;
//
///**
// * @author Chen Lin
// * @date 2020-02-09
// */
//
//public interface IFollowService {
//	
//	/*
//	 * user1 follow user 2
//	 * @param User1
//	 * @param User2
//	 * */
//	public void follow(UserFollow userFollow);
//	
//	/*
//	 * user1 unfollow user 2
//	 * @param User1
//	 * @param User2
//	 * */
//	public void unfollow(UserFollow userFollow);
//	
//	/*
//	 * Method to get user list follow input user
//	 *  @param user a user
//	 * 	@return the list who follow the input user
//	 * */
//	public List<UserFollow> getFollowersList(User user);
//	
//	
//	/*
//	 * Method to get user list who is followed by input user
//	 *  @param user a user
//	 * 	@return the list who is followed by input user
//	 * */
//	public List<FollowRelationship> getFollowingList (User user);
//	
//	public int countFollower(User user);
//	
//	public int countFollowing(User user);
//
//}
