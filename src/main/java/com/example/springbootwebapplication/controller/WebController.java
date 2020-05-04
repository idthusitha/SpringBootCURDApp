package com.example.springbootwebapplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "index";

	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String testPage() {
		return "testpage";

	}
}
