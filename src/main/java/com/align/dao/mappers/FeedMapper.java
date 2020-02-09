package com.align.dao.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.align.models.Feed;
import com.align.models.User;

@Mapper
public interface FeedMapper {

	@Insert("insert into feeds(id, userid, content)" 
			+" values(#{id},#{userid},#{content})")
    int insert(Feed record);

	@Select("select id, userid,content"
	+" from feeds"
	+" where userid = #{userid}")
	public List<Feed> selectFeedByUser(User user);
	

	@Select("select id, userid, content"
	+" from feeds"
	+" where id = #{id}")
	public Feed selectFeedById(Integer id);
	
	@Select({
		"<script>",
		"select",
		"id, userid, content",
		"from feeds",
		"where userid in",
		"<foreach collection = 'ids' item = 'id' open = '(' separator=',' close=')'>",
		"#{id}",
		"</foreach>",
		"</script>"
	})
	public List<Feed> selectFeedByUsers(@Param("ids") List<Integer> ids);
}