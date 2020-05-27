package com.align.config.security;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.token.DefaultUserAuthenticationConverter;

import com.align.models.User;

/**
 * @author Chen Lin
 * @date 2020-05-27
 */

@Configuration
public class CustomUserAuthenticationConverter extends DefaultUserAuthenticationConverter {

	final String USERID = "user_id";
	
	//重写DefaultUserAuthenticationConverter的方法，
	//1.添加user_id字段进jwt中
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, ?> convertUserAuthentication(Authentication authentication) {
		Map<String, Object> response = new LinkedHashMap<String, Object>();
		response = (Map<String, Object>) super.convertUserAuthentication(authentication);
		response.put("user_id", ((User)authentication.getPrincipal()).getId());
		return response;
	}
}
