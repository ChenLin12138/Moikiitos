package com.align.dao.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.Primary;

import com.align.models.User;

@Primary
@Mapper
public interface UserMapper {
	
	@Insert("insert into users(id, username, email, password)" 
			+" values(#{id},#{username},#{email},#{password})")
    int insert(User record);

	@Select("select id, username, email, password"
	+" from users"
	+" where email = #{email}")
	public User selectUserByemail(String email);
	
	@Select("select id, username, email, password"
	+" from users"
	+" where email like #{username}")
	public List<User> selectUserByName(String name);
	
	@Select("select id, username, email, password"
	+" from users"
	+" where id = #{id}")
	public User selectUserById(Integer id);
	
	
}