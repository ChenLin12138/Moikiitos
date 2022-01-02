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
	public void getAllMenusWithRole() {
		List<Menu> menus = service.getAllMenusWithRole();
		Assert.assertTrue(menus.size()==2);
	}
	
}
