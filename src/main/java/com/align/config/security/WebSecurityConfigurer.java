package com.align.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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

//扩展核心的Spring Security的WebSecurityConfigurerAdapter
@Configuration
//显示添加注解@EnableWebSecurity，不然junit会找不到一些关于spring security的依赖。
@EnableWebSecurity
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter{
	
	@Autowired
	UserService userService;
	
	@Value("${security.enable-csrf}")
	private boolean csrfEnabled;
	
	
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
//		auth.inMemoryAuthentication().withUser("chenlin")
//		.password(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("password1"))
//		.roles("USERS")
//		.and()
//		.withUser("zdm")
//		.password(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("password2"))
//		.roles("USERS","ADMIN");
		auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	//打开这个配置，他就送我这个错误
	//Consider defining a bean named 'mvcHandlerMappingIntrospector'
	//添加一下逻辑，想允许cors,但是没有作用
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		super.configure(http);
//		
//		if(!csrfEnabled) {
//			http.cors().and()
//			.csrf().disable();
//		}
//	}
}
