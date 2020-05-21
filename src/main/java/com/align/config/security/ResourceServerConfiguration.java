package com.align.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;

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
		http.authorizeRequests()
		.antMatchers(HttpMethod.GET, "/v1/moikiitos/**")
		.authenticated();
		
		//http://localhost:8513/swagger-ui.html 
//		http://localhost:8513/oauth/token
//		//有用删除权限的角色申明
//		.antMatchers(HttpMethod.DELETE,"/v1/organizations/**")
//		.hasRole("ADMIN")
//		.antMatchers(HttpMethod.POST,"/")
//		//任何/v1下面的资源都需要被保护
//		.anyRequest()
//		.authenticated()
//		;
	}
}
