package com.bhaskar.taskmonks.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {
	
	@RequestMapping(value = {"/","/welcome"}, method = RequestMethod.GET)
	public String welcomePage(Model model) {
		return "index";
	}
	
	@RequestMapping(value = {"/admin","/admin/welcome"}, method = RequestMethod.GET)
	public String adminPage(Model model) {
		return "admin/index";
	}

}
