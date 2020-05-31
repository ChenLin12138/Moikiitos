package com.align.dao.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Primary;

import com.align.models.User;

@Primary
@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);
    
    User selectByEmail(String email);
    
    User selectByUsername(String name);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

	List<User> selectByEmailLike(String email);

	List<User> selectByUsernameLike(String username);
}