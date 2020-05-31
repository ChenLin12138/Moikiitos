package com.align.dao.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Primary;

import com.align.models.UserFollow;
import com.align.view.UserFollowView;

@Primary
@Mapper
public interface UserFollowMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserFollow record);

    int insertSelective(UserFollow record);

    UserFollow selectByPrimaryKey(Integer id);
    
    UserFollow selectByUserIdAndFollowId(Integer uid, Integer fid);

    int updateByPrimaryKeySelective(UserFollow record);

    int updateByPrimaryKey(UserFollow record);
    
    List<UserFollowView> selectByUserIdWithNameAndEmail(Integer uid);
    
    List<UserFollowView> selectByFollowIdWithNameAndEmail(Integer fid);
    
    List<UserFollow> selectByUserId(Integer uid);
    
    List<UserFollow> selectByFollowId(Integer fid);
    
    int countByUserId(Integer userid); 
    
    int countByFollowId(Integer followid);
    
}