package com.align.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.align.services.UserService;

/**
 * @author Chen Lin
 * @date 2019-09-30
 */
/*
 * 继承WebSecurityConfigurerAdapter表达用户级别的账号和密码设置
 * 暂时采用内存数据库的方式配置用户名，密码，角色
 * */

//在我们的项目中，有spring mvc, security, oauth方式
//Spring Security 本身是通过 Filter 实现的，如果没有对其单独做 CORS 的处理，
//在 Web Security 报错 401 的时候是不会返回相应的 CORS 的字段的。这会导致出现的 401 
//错误成为了一个无法进行跨域的错误，导致前端程序无法正常的处理 401响应
@Order(Ordered.HIGHEST_PRECEDENCE)
//扩展核心的Spring Security的WebSecurityConfigurerAdapter
@Configuration
//显示添加注解@EnableWebSecurity，不然junit会找不到一些关于spring security的依赖。
@EnableWebSecurity
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter{
	
	@Autowired
	UserService userService;
	
	//自定义url可以访问的类
//	@Autowired
//    CustomFilterInvocationSecurityMetadataSource customFilterInvocationSecurityMetadataSource;
	
	@Override
	@Bean(name = BeanIds.AUTHENTICATION_MANAGER)
	public AuthenticationManager authenticationManagerBean() throws Exception{
		return super.authenticationManagerBean();
	}
	
	@Override
	@Bean
	public UserDetailsService userDetailsServiceBean() throws Exception{
		return super.userDetailsServiceBean();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
        http
        .requestMatchers().antMatchers(HttpMethod.OPTIONS, "/oauth/**")
        .and()
        .csrf().disable().formLogin()
        .and()
        .cors()
        ;
    }
}
