package com.align.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @author Chen Lin
 * @date 2019-10-17
 */
/*
 * JTW Token的一些配置，包含
 * 1.jwtSigningKey
 * 2.tokenService的配置
 * 
 * */
@Configuration
public class JWTTokenStoreConfig {
	
	@Autowired
	private ServiceConfig serviceConfig;
	
	@Bean
	public TokenStore tokenStore(){
		return new JwtTokenStore(jwtAccessTokenConverter());
	}
//
//	@Bean
//	@Primary
//	public DefaultTokenServices tokenService() {
//		DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
//		defaultTokenServices.setTokenStore(tokenStore());
//		defaultTokenServices.setSupportRefreshToken(true);
//		//设置accessToken过期时间
//		//这个过期时间的设置，仅仅在使用非jwt的时候才有用。如果同时注入jtwtokenstore和此tokenservice则失效
//		defaultTokenServices.setAccessTokenValiditySeconds(accessTokenValiditySeconds);
//		return defaultTokenServices;
//	}
	
	@Bean
	public JwtAccessTokenConverter jwtAccessTokenConverter() {
		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
		converter.setSigningKey(serviceConfig.getJwtSigningKey());
		return converter;
	}
}
