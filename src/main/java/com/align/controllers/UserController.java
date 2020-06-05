package com.align.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.align.models.RespBean;
import com.align.models.User;
import com.align.models.UserEmail;
import com.align.models.UserRequestInfo;
import com.align.services.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author Chen Lin
 * @date 2020-05-31
 */

@Api(tags="UserController")
@RestController
@RequestMapping(value = "/v1/moikiitos/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@ApiOperation(value = "根据keywords查找用户" ,  notes="keywords用户模糊匹配用户名和用户邮箱")
	@RequestMapping(value = "/keyword/{keyword}", method = RequestMethod.GET)
	public List<UserEmail> searchUser(@PathVariable("keyword") String keyword) {
		
		List<UserEmail> result = new ArrayList<UserEmail>();
		List<User> users;
		
		if(keyword.contains("@")) {
			users = userService.getUserByEmailLike(keyword);
		}else {
			users = userService.getUserByUsernameLike(keyword);
			
		}
		
		if(null !=users) {
			for(User user : users) {
				UserEmail userEmail = new UserEmail();
				userEmail.setUserId(user.getId());
				userEmail.setUserName(user.getUsername());
				userEmail.setEmail(user.getEmail());
				result.add(userEmail);
			}
		}
		return result;
	}
	
	@ApiOperation(value = "新用户注册" ,  notes="添加新用户")
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public RespBean register(@RequestBody UserRequestInfo userRequestInfo) {
		
		User user = new User();
		user.setUsername(userRequestInfo.getUsername());
		user.setPassword(userRequestInfo.getPassword());
		user.setEmail(userRequestInfo.getEmail());
		if(userService.registerUser(user)) {
			return RespBean.ok("用户添加成功!");
		}else {
			return RespBean.error("用户添加失败！");
		}
	}
	
}
