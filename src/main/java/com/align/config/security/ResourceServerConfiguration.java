package com.align.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

/**
 * @author Chen Lin
 * @date 2019-10-11
 */

/*
 * 继承ResourceServerConfigurerAdapter表达那些资源会被什么样的角色
 * 配置被保护的信息
 * ResourceServerConfigurerAdapter这个类是拿来给OA2用的
 * 
 * */
@Configuration
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
	
	//自定义url可以访问的类
	@Autowired
	FilterInvocationSecurityMetadataSource customFilterInvocationSecurityMetadataSource;
	
	//DecisionManager
	@Autowired
	AccessDecisionManager customUrlDecisionManager;
	
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
		.authorizeRequests()
		.withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
          @Override
          public <O extends FilterSecurityInterceptor> O postProcess(O object) {
        	  object.setAccessDecisionManager(customUrlDecisionManager);
              object.setSecurityMetadataSource(customFilterInvocationSecurityMetadataSource);
              return object;
          }
      });		
	}
}
