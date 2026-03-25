package com.tmf.had.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login")
public class LoginController {
	@RequestMapping(path = "/test1", method = RequestMethod.GET)
	public String test1() {
		System.out.println("LoginController.test1()");
		return null;
	}

	@RequestMapping(path = "/test2", method = RequestMethod.GET)
	public String test2() {
		System.out.println("LoginController.test2()");
		return null;
	}

}
