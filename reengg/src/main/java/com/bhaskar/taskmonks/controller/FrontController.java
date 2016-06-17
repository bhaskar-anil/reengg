package com.bhaskar.taskmonks.controller;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bhaskar.taskmonks.domain.Category;
import com.bhaskar.taskmonks.domain.CustomerDetails;
import com.bhaskar.taskmonks.domain.Task;
import com.bhaskar.taskmonks.domain.TaskAttribute;
import com.bhaskar.taskmonks.domain.TaskerDetails;
import com.bhaskar.taskmonks.service.AdminUserServiceInterface;
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
	
	@Autowired
	protected AdminUserServiceInterface adminService;

	
	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public String login(Model model) {		
		return "login";
	}

	@RequestMapping(value = { "/", "/categories" }, method = RequestMethod.GET)
	public String welcome(Model model) {
		model.addAttribute("allCategories", (ArrayList<Category>) categoryService.getAllCategories());
		return "index";
	}

	@RequestMapping(value = "/categories/{catUri}", method = RequestMethod.GET)
	public String categoryHome(@PathVariable("catUri") String catUri, Model model) {
		ArrayList<Task> allTasks = (ArrayList<Task>) taskService.findAllTasksByCatUri(catUri);
		model.addAttribute("allServices", allTasks);

		/*We need the category before iterating the tasks list so let's extract a category object*/
		if (allTasks.isEmpty()) {
			Category cat = categoryService.findByCatUri(catUri);
			model.addAttribute("category", cat);
			return "category";
		}
		
		model.addAttribute("category", allTasks.iterator().next().getCategory());
		return "category";
	}
	
	@RequestMapping(value = "/services/{taskUri}", method = RequestMethod.GET)
	public String serviceHome(@PathVariable("taskUri") String taskUri, Model model){
		Task task = taskService.findTaskByTaskUri(taskUri);
		model.addAttribute("task", task);
		
		/*Get all task attributes*/
		Collection<TaskAttribute> allAtrs = (Collection<TaskAttribute>)taskAtrService
																.getAllTasksAtr(task.getTaskId());
		model.addAttribute("allAtrs", allAtrs);
		
		return "service";
	}
	
	@RequestMapping(value = "/become-tasker", method = RequestMethod.GET)
	public String becomeTasker(Model model) {
		TaskerDetails taskerDetails = new TaskerDetails();
		
		model.addAttribute("userType", "TASKER");
		model.addAttribute("taskerDetails", taskerDetails);
		return "register";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String userRegister(Model model) {
		CustomerDetails customerDetails = new CustomerDetails();
		
		model.addAttribute("userType", "CUSTOMER");
		model.addAttribute("taskerDetails", customerDetails);
		return "register";
	}
	
	@RequestMapping(value = "/some-top-secret-url", method = RequestMethod.GET)
	public String adminRegister(Model model) {

		model.addAttribute("userType", "ADMIN");
		return "register";
	}

}
