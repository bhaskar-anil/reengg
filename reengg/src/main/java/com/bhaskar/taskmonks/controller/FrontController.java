package com.bhaskar.taskmonks.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bhaskar.taskmonks.domain.Category;
import com.bhaskar.taskmonks.domain.Task;
import com.bhaskar.taskmonks.service.AttributeValuesServiceInterface;
import com.bhaskar.taskmonks.service.CategoryServiceInterface;
import com.bhaskar.taskmonks.service.TaskAtrServiceInterface;
import com.bhaskar.taskmonks.service.TaskServiceInterface;

@Controller
public class FrontController {
	
	@Autowired
	protected CategoryServiceInterface categoryService;

	@Autowired
	protected TaskServiceInterface taskService;

	@Autowired
	protected TaskAtrServiceInterface taskAtrService;
	
	@Autowired
	protected AttributeValuesServiceInterface atrValuesService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(Model model) {
		model.addAttribute("allCategories", (ArrayList<Category>)categoryService.getAllCategories());
		return "index";
	}
	
	@RequestMapping(value = "/categories/{catName}", method = RequestMethod.GET)
	public String categoryHome(@PathVariable("catName") String catName, Model model) {
		model.addAttribute("allServices", (ArrayList<Task>)taskService.getAllTasks());
		return "category";
	}

}
