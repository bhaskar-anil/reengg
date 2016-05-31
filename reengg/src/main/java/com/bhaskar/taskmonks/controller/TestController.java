package com.bhaskar.taskmonks.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bhaskar.taskmonks.domain.Category;
import com.bhaskar.taskmonks.service.CategoryServiceInterface;

@Controller
public class TestController {
	
	@Autowired
	CategoryServiceInterface categoryService;
	
	@RequestMapping(value = {"/","/welcome"}, method = RequestMethod.GET)
	public String welcome(Model model) {
		model.addAttribute("category",new Category());
		model.addAttribute("allCategories", (ArrayList<Category>)categoryService.getAllCategories());
		return "index";
	}
}
