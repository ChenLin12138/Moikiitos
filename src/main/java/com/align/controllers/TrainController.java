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

@Api(tags="TrainController")
@RestController
@RequestMapping(value = "/v1/moikiitos/train")
public class TrainController {

	@ApiOperation(value = "获取Train信息" ,  notes="获取培训信息")
	@RequestMapping(method = RequestMethod.GET)
	public InfoView getTrain() {
		InfoView view = new InfoView();
		view.setInfo("This is trainning Info...");
		return view;
	}
}
