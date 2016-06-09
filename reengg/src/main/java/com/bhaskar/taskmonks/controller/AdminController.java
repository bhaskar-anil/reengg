package com.bhaskar.taskmonks.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bhaskar.taskmonks.domain.AttributeValues;
import com.bhaskar.taskmonks.domain.Category;
import com.bhaskar.taskmonks.domain.Task;
import com.bhaskar.taskmonks.domain.TaskAttribute;
import com.bhaskar.taskmonks.service.AttributeValuesServiceInterface;
import com.bhaskar.taskmonks.service.CategoryServiceInterface;
import com.bhaskar.taskmonks.service.TaskAtrServiceInterface;
import com.bhaskar.taskmonks.service.TaskServiceInterface;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	protected CategoryServiceInterface categoryService;

	@Autowired
	protected TaskServiceInterface taskService;

	@Autowired
	protected TaskAtrServiceInterface taskAtrService;
	
	@Autowired
	protected AttributeValuesServiceInterface atrValuesService;

	@RequestMapping(value = { "" }, method = RequestMethod.GET)
	public String adminHome(Model model) {
		return "admin/index";
	}

	@RequestMapping(value = { "/category", "/savecat" }, method = RequestMethod.GET)
	public String saveCatPage(Model model) {
		model.addAttribute("category", new Category());
		model.addAttribute("icons", getIcons());
		model.addAttribute("allCategories", (ArrayList<Category>) categoryService.getAllCategories());
		return "admin/saveCatPage";
	}

	@RequestMapping(value = { "/category/save" }, method = RequestMethod.POST)
	public String saveCategory(@ModelAttribute("category") Category category,
			final RedirectAttributes redirectAttributes) {

		if (categoryService.saveCategory(category) != null) {
			redirectAttributes.addFlashAttribute("saveCategory", "success");
		} else {
			redirectAttributes.addFlashAttribute("saveCategory", "unsuccess");
		}

		return "redirect:/admin/savecat";
	}

	@RequestMapping(value = "/category/{operation}/{catId}", method = RequestMethod.GET)
	public String editRemoveCategory(@PathVariable("operation") String operation, @PathVariable("catId") Long catId,
			final RedirectAttributes redirectAttributes, Model model) {
		if (operation.equals("delete")) {
			if (categoryService.deleteCategory(catId)) {
				redirectAttributes.addFlashAttribute("deletion", "success");
			} else {
				redirectAttributes.addFlashAttribute("deletion", "unsuccess");
			}
		} else if (operation.equals("edit")) {
			Category editCategory = categoryService.findCategory(catId);
			if (editCategory != null) {
				model.addAttribute("icons", getIcons());
				model.addAttribute("editCategory", editCategory);
				return "admin/editCatPage";
			} else {
				redirectAttributes.addFlashAttribute("status", "notfound");
			}
		}

		return "redirect:/admin/savecat";
	}

	@RequestMapping(value = "/category/update", method = RequestMethod.POST)
	public String updateCategory(@ModelAttribute("editCategory") Category editCategory,
			final RedirectAttributes redirectAttributes) {
		if (categoryService.editCategory(editCategory) != null) {
			redirectAttributes.addFlashAttribute("edit", "success");
		} else {
			redirectAttributes.addFlashAttribute("edit", "unsuccess");
		}
		return "redirect:/admin/savecat";
	}
	/*-----------------------Admin Category request-mappings END here--------------------------------*/
	
	
	
	
	

	/*-----------------------Admin Services request-mappings START here--------------------------------*/

	@RequestMapping(value = { "/service", "/saveservice" }, method = RequestMethod.GET)
	public String saveTaskPage(Model model) {
		model.addAttribute("task", new Task());
		model.addAttribute("icons", getIcons());
		model.addAttribute("allTasks", (ArrayList<Task>) taskService.getAllTasks());
		model.addAttribute("allCategories", (ArrayList<Category>) categoryService.getAllCategories());
		return "admin/saveTaskPage";
	}

	@RequestMapping(value = { "/service/save" }, method = RequestMethod.POST)
	public String saveTask(@ModelAttribute("task") Task task, final RedirectAttributes redirectAttributes) {

		if (taskService.saveTask(task) != null) {
			redirectAttributes.addFlashAttribute("saveTask", "success");
		} else {
			redirectAttributes.addFlashAttribute("saveTask", "unsuccess");
		}

		return "redirect:/admin/saveservice";
	}

	@RequestMapping(value = "/service/{operation}/{taskId}", method = RequestMethod.GET)
	public String editRemoveTask(@PathVariable("operation") String operation, @PathVariable("taskId") Long taskId,
			final RedirectAttributes redirectAttributes, Model model) {
		if (operation.equals("delete")) {
			if (taskService.deleteTask(taskId)) {
				redirectAttributes.addFlashAttribute("deletion", "success");
			} else {
				redirectAttributes.addFlashAttribute("deletion", "unsuccess");
			}
		} else if (operation.equals("edit")) {
			Task editTask = taskService.findTask(taskId);
			if (editTask != null) {
				model.addAttribute("icons", getIcons());
				model.addAttribute("allCategories", (ArrayList<Category>) categoryService.getAllCategories());
				model.addAttribute("editTask", editTask);
				return "admin/editTaskPage";
			} else {

				redirectAttributes.addFlashAttribute("status", "notfound");
			}
		}
		return "redirect:/admin/saveservice";
	}

	@RequestMapping(value = "/service/update", method = RequestMethod.POST)
	public String updateTask(@ModelAttribute("editTask") Task editTask, final RedirectAttributes redirectAttributes) {
		if (taskService.editTask(editTask) != null) {
			redirectAttributes.addFlashAttribute("edit", "success");
		} else {
			redirectAttributes.addFlashAttribute("edit", "unsuccess");
		}
		return "redirect:/admin/saveservice";
	}
	/*-------------Task Request Mappings END here--------------------------------*/
	
	
	
	
	

	/*--------------Task Attribute Request Mappings START here----------------------*/
	
	@RequestMapping(value = "/service/atrs/{taskId}", method = RequestMethod.GET)
	public String showTaskAttributes(@PathVariable("taskId") Long taskId, Model model) {
		
		model.addAttribute("task", taskService.findTask(taskId));
		model.addAttribute("taskAttribute", new TaskAttribute());
		model.addAttribute("types", getAttrTypes());
		model.addAttribute("allAttributes", taskAtrService.getAllTasksAtr(taskId));
		
		return "admin/saveTaskAtrPage";
	}
	
	@RequestMapping(value = "/service/atrs/save", method = RequestMethod.POST)
	public String saveTaskAttributes(@ModelAttribute("taskAttribute") TaskAttribute taskAttribute, final RedirectAttributes redirectAttributes) {
		
		taskAtrService.saveTaskAtr(taskAttribute);
		return "redirect:/admin/service/atrs/"+taskAttribute.getTask().getTaskId();
	}

	@RequestMapping(value = "/service/atrs/{operation}/{taskAtrId}", method = RequestMethod.GET)
	public String editRemoveTaskAttributes(@PathVariable("operation") String operation,
			@PathVariable("taskAtrId") Long taskAtrId, final RedirectAttributes redirectAttributes, Model model) {
		Long taskId = taskAtrService.findTaskAtr(taskAtrId).getTask().getTaskId();
		if (operation.equals("delete")) {
			if (taskAtrService.deleteTaskAtr(taskAtrId)) {
				redirectAttributes.addFlashAttribute("deletion", "success");
			} else {
				redirectAttributes.addFlashAttribute("deletion", "unsuccess");
			}
		} else if (operation.equals("edit")) {
			TaskAttribute editTaskAtr = taskAtrService.findTaskAtr(taskAtrId);
			//Task editTask = taskService.findTask(taskId);
			if (editTaskAtr != null) {
				model.addAttribute("types", getAttrTypes());
				model.addAttribute("editTaskAtr", editTaskAtr);
				return "admin/editTaskAtrPage";
			} else {

				redirectAttributes.addFlashAttribute("status", "notfound");
			}
		}
		
		return "redirect:/admin/service/atrs/"+taskId;
	}
	
	@RequestMapping(value = "/service/atrs/update", method = RequestMethod.POST)
	public String updateTaskAtrs(@ModelAttribute("editTaskAtr") TaskAttribute editTaskAtr, final RedirectAttributes redirectAttributes) {
		if (taskAtrService.editTaskAtr(editTaskAtr) != null) {
			redirectAttributes.addFlashAttribute("edit", "success");
		} else {
			redirectAttributes.addFlashAttribute("edit", "unsuccess");
		}
		return "redirect:/admin/service/atrs/"+editTaskAtr.getTask().getTaskId();
	}
	/*--------------Task Attribute Request Mappings END here-------------------------*/
	
	
	
	
/*--------------Task Attribute Request Mappings START here----------------------*/
	
	@RequestMapping(value = "/service/atrs/values/{atrId}", method = RequestMethod.GET)
	public String showAtrValues(@PathVariable("atrId") Long atrId, Model model) {
		
		model.addAttribute("taskAtr", taskAtrService.findTaskAtr(atrId));
		model.addAttribute("atrValues", new AttributeValues());
		model.addAttribute("types", getAttrTypes());
		model.addAttribute("allAttrValues", atrValuesService.getAllAtrValues(atrId));
		
		return "admin/saveAtrValuePage";
	}
	
	@RequestMapping(value = "/service/atrs/values/save", method = RequestMethod.POST)
	public String saveTaskAttributes(@ModelAttribute("atrValues") AttributeValues atrValues, final RedirectAttributes redirectAttributes) {
		
		atrValuesService.saveAtrValue(atrValues);
		return "redirect:/admin/service/atrs/values/"+atrValues.getTaskAttribute().getAtrId();
	}
	
	@RequestMapping(value = "/service/atrs/values/{operation}/{atrValueId}", method = RequestMethod.GET)
	public String editRemoveAtrValues(@PathVariable("operation") String operation,
			@PathVariable("atrValueId") Long atrValueId, final RedirectAttributes redirectAttributes, Model model) {
		Long atrId = atrValuesService.findAtrValue(atrValueId).getTaskAttribute().getAtrId();
		//Long taskId = taskAtrService.findTaskAtr(taskAtrId).getTask().getTaskId();
		if (operation.equals("delete")) {
			if (atrValuesService.deleteAtrValue(atrValueId)) {
				redirectAttributes.addFlashAttribute("deletion", "success");
			} else {
				redirectAttributes.addFlashAttribute("deletion", "unsuccess");
			}
		} else if (operation.equals("edit")) {
			AttributeValues editAtrValues = atrValuesService.findAtrValue(atrValueId);
			//TaskAttribute editTaskAtr = taskAtrService.findTaskAtr(taskAtrId);
			//Task editTask = taskService.findTask(taskId);
			if (editAtrValues != null) {
				//model.addAttribute("types", getAttrTypes());
				model.addAttribute("editAtrValues", editAtrValues);
				return "admin/editAtrValuesPage";
			} else {

				redirectAttributes.addFlashAttribute("status", "notfound");
			}
		}		
		return "redirect:/admin/service/atrs/values/"+atrId;
	}
	
	@RequestMapping(value = "/service/atrs/values/update", method = RequestMethod.POST)
	public String updateAtrValues(@ModelAttribute("editAtrValues") AttributeValues editAtrValues, final RedirectAttributes redirectAttributes) {
		if (atrValuesService.editAtrValue(editAtrValues) != null) {
			redirectAttributes.addFlashAttribute("edit", "success");
		} else {
			redirectAttributes.addFlashAttribute("edit", "unsuccess");
		}
		return "redirect:/admin/service/atrs/values/"+editAtrValues.getTaskAttribute().getAtrId();
	}
	/*--------------Task Attribute Request Mappings END here-------------------------*/
	
	

	public static List<String> getIcons() {
		return Arrays.asList(new String[] { "glyphicon glyphicon-cloud", "glyphicon glyphicon-envelope",
				"glyphicon glyphicon-glass", "glyphicon glyphicon-music", "glyphicon glyphicon-search",
				"glyphicon glyphicon-heart", "glyphicon glyphicon-film", "glyphicon glyphicon-road",
				"glyphicon glyphicon-camera", "glyphicon glyphicon-plane", "glyphicon glyphicon-briefcase",
				"glyphicon glyphicon-education", "glyphicon glyphicon-globe", "glyphicon glyphicon-calendar" });
	}

	public static List<String> getAttrTypes() {
		return Arrays.asList(new String[] { "SELECT", "RADIO", "DATE", "TEXT", "LOCATION" });
	}

}
