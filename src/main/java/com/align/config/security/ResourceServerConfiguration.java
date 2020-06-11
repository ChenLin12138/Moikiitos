package com.align.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * @author Chen Lin
 * @date 2019-10-11
 */

/*
 * 继承ResourceServerConfigurerAdapter表达那些资源会被什么样的角色
 * 配置被保护的信息
 * */
@Configuration
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
	
	@Override
	public void configure (HttpSecurity http) throws Exception {
		
		//测试用的
//		http.authorizeRequests().anyRequest().permitAll();
		
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/v1/moikiitos/**").authenticated()
		.and()
		.authorizeRequests().antMatchers(HttpMethod.POST,"/v1/moikiitos/user/").permitAll()
		.and()
		.authorizeRequests().antMatchers(HttpMethod.POST,"/v1/moikiitos/**").authenticated()
		.and()
		.csrf().disable().formLogin()
		.and()
		.cors();
		
	}
}
