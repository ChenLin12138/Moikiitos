package com.align.dao.mappers;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.align.models.User;

@Mapper
public interface UserMapper {
	
	@Insert("insert into users(id, name, email, password)" 
			+" values(#{id},#{name},#{password})")
    int insert(User record);

	@Select("select id, userid,content"
	+" from users"
	+" where email = #{email}")
	public User selectUserByemail(User record);
}