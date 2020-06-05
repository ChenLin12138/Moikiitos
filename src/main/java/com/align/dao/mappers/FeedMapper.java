package com.align.dao.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.Primary;

import com.align.models.Feed;
import com.align.models.User;

@Primary
@Mapper
public interface FeedMapper {

    int insert(Feed record);

	public List<Feed> selectFeedByUserId(User user);
	
	public Feed selectByPrimaryKey(Integer id);
	
	public List<Feed> selectFeedByUsersId(@Param("ids") List<Integer> ids);
}