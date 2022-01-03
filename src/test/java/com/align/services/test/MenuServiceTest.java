package com.align.services.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.align.models.Menu;
import com.align.services.MenuService;

/**
 * @author Chen Lin
 * @date 2020-02-09
 */

public class MenuServiceTest extends BaseServiceTest {
	
	@Autowired
	private MenuService service;
	
	
	@Before
	public void setup() {
	
	}
	
	@Test
	public void getAllMenusWithRoleTest() {
		List<Menu> menus = service.getAllMenusWithRole();
		Assert.assertTrue(menus.size()==2);
	}
	
	@Test 
	public void getAllMenusByUserIdTest() {
		List<Menu> menus = service.getAllMenusByUserId(4);
		Assert.assertTrue(menus.size()==1);
	}
	
}
