package com.bhaskar.taskmonks.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
@RequestMapping("/tasker")
public class TaskerController {
	
	@RequestMapping(value = {"/",""}, method = RequestMethod.GET)
	public String welcomeTasker(Model model) {
		
		return "tasker/index";
	}
	

}
