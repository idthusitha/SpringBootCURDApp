package com.example.springbootwebapplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebController {

//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String index() {
//		return "index.html";
//	}
	
//	@RequestMapping("/")
//	public @ResponseBody String greeting() {
//		return "Hello, World";
//	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public @ResponseBody String testPage() {
		return "Hello, World";

	}
}
