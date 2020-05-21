package com.align.config.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import com.align.services.UserService;

/**
 * @author Chen Lin
 * @date 2019-10-17
 */

/*
 * 继承自AuthorizationServerConfigurerAdapter
 * AuthorizationServerConfigurerAdapter中有3个重要的属性
 * 1.ClientDetailsServiceConfigurer
 * 配置客户端应用程序账号密码
 * 定义客户端信息服务的配置程序，即应用程序以jdbc/内存方式存储用户密码，应用程序层面的账号密码配置。
 * 2.AuthorizationServerSecurityConfigurer
 * 3.AuthorizationServerEndpointsConfigurer
 * 定义授权和令牌端点以及令牌服务。
 * */
@Configuration
@EnableAuthorizationServer
public class JWTOAuth2Config extends AuthorizationServerConfigurerAdapter{
	
	//accessToken过期时间设置
	private static final int accessTokenValiditySeconds = 300 * 1 * 1;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
    @Autowired
    private TokenEnhancer jwtTokenEnhancer;
	
    
    @Autowired
    private TokenStore tokenStore;
    
    @Autowired
    private JwtAccessTokenConverter jwtAccessTokenConverter;
    

    @Autowired
    private UserService userService;
    
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		
		TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
		tokenEnhancerChain.setTokenEnhancers(Arrays.asList(jwtTokenEnhancer, jwtAccessTokenConverter));
		
		endpoints
		.tokenStore(tokenStore)
		.accessTokenConverter(jwtAccessTokenConverter)
		.tokenEnhancer(tokenEnhancerChain)
		.authenticationManager(authenticationManager)
		.userDetailsService(userService);
	}


	//配置客户端应用程序账号密码
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

      clients.inMemory()
              .withClient("organization")
              .secret(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("organization666"))
              .authorizedGrantTypes("refresh_token", "password", "client_credentials")
              .scopes("webclient", "mobileclient")
              //配置token失效时间，这里有个奇怪的地方，如果失效时间配置在tokenservice中使用普通token有效
              //但是切换到jwt的时候无效。
              .accessTokenValiditySeconds(accessTokenValiditySeconds);
  }
}
