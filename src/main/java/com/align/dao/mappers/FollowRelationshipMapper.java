package com.align.dao.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.Primary;

import com.align.models.FollowRelationship;

@Primary
@Mapper
public interface FollowRelationshipMapper {
	
	@Insert("insert into followrelationship(userid, followid)" 
			+" values(#{userid},#{followid})")
	public int insert(FollowRelationship record);

	@Delete("delete "
	+" from followrelationship"
	+" where userid = #{userid} and  followid = #{followid}")
	public int deleteRecord(FollowRelationship record);
	
	@Select("select userid, followid, username, email"
			+" from followrelationship"
			+" inner join users"
			+" on followid = users.id"
			+" where userid = #{userid}")
			public List<FollowRelationship> selectByUserId(FollowRelationship record);
	
	@Select("select userid, followid, username, email"
			+" from followrelationship"
			+" inner join users"
			+" on userid = users.id"
			+" where followid = #{followid}")
			public List<FollowRelationship> selectByFollowId(FollowRelationship record);
	
	@Select("select count(*)"
			+" from followrelationship"
			+" where userid = #{userid}")
			public int countByUserId(FollowRelationship record);
	
	
	@Select("select count(*)"
			+" from followrelationship"
			+" where followid = #{followid}")
			public int countByFollowId(FollowRelationship record);
}