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
	
	@Insert("insert into users(id, name, email, password)" 
			+" values(#{id},#{name},#{email},#{password})")
    int insert(User record);

	@Select("select id, name, email, password"
	+" from users"
	+" where email = #{email}")
	public User selectUserByemail(String email);
	
	@Select("select id, name, email, password"
	+" from users"
	+" where email like #{name}")
	public List<User> selectUserByName(String name);
	
	@Select("select id, name, email, password"
	+" from users"
	+" where id = #{id}")
	public User selectUserById(Integer id);
	
	
}