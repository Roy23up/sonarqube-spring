package com.mx.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "home")
public class HomeController {

	@GetMapping("login")
	public String login() {
		return "login";
	}
	
	@GetMapping("frbidn")
	public String forbidden() {
		return "frbidn";
	}
	
}
