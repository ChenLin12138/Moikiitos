package com.align.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.align.view.InfoView;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author Chen Lin
 * @date 2020-02-09
 */

@Api(tags="SalaryController")
@RestController
@RequestMapping(value = "/v1/moikiitos/salary")
public class SalaryController {
	
	@ApiOperation(value = "获取Salary信息" ,  notes="获取工资信息")
	@RequestMapping(method = RequestMethod.GET)
	public InfoView getSalary() {
		InfoView view = new InfoView();
		view.setInfo("This is salary Info...");
		return view;
	
	}
}
