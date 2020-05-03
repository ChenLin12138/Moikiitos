package com.align.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.align.dao.mappers.FeedMapper;
import com.align.dao.mappers.FollowRelationshipMapper;
import com.align.dao.mappers.UserMapper;

/**
 * @author Chen Lin
 * @date 2019-05-18
 */

@Configuration
public class MybatisMapperConfig {
	
	@Autowired
	BasicDataSource dataSource;

	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource);
		return (SqlSessionFactory) sqlSessionFactory.getObject();
	}

	@Bean
	public SqlSessionTemplate sqlSessionTemplate() throws Exception {
		SqlSessionTemplate sessionTemplate = new SqlSessionTemplate(sqlSessionFactory());
		sessionTemplate.getConfiguration().addMappers("com.align.dao.mappers");
		return sessionTemplate;
	}
	
	@Bean
	public FeedMapper feedMapper() throws Exception {

		return sqlSessionTemplate().getMapper(FeedMapper.class);

	}
	
	@Bean
	public FollowRelationshipMapper followRelationshipMapper() throws Exception {

		return sqlSessionTemplate().getMapper(FollowRelationshipMapper.class);

	}
	
	@Bean
	public UserMapper usersMapper() throws Exception {

		return sqlSessionTemplate().getMapper(UserMapper.class);

	}
}
