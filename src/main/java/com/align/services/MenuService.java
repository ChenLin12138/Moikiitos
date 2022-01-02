package com.align.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.align.dao.mappers.MenuMapper;
import com.align.models.Menu;

/**
 * @author Chen Lin
 * @date 2021-01-01
 */

@Service
public class MenuService {

	@Autowired
	private MenuMapper mapper;

	public List<Menu> getAllMenusWithRole() {
		
		return mapper.getAllMenusWithRole();
	}
	
}
