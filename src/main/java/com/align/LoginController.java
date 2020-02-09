package com.align;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) throws IOException {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login1(Model model) throws IOException {
		return "login";
	}
	
	@RequestMapping(value = "/regist", method = RequestMethod.GET)
	public String signUp(Model model) throws IOException {
		return "registration";
	}
}
