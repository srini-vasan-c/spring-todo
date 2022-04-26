package com.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.model.Todo;
import com.model.User;
import com.service.TodoService;
import com.service.UploadService;

@Controller
public class MainController {
	@Autowired
	TodoService todoService;
	@Autowired
	ModelAndView modelAndView;
	@Autowired
	UploadService uploadService;

	@RequestMapping("/dashboard")
	public String dashboard(Model m) {
		return "dashboard";
	}

	@RequestMapping("/add")
	public String add(Model m) {
		m.addAttribute("page", "add");
		return "dashboard";
	}

	@RequestMapping(value = "/save-todo", method = RequestMethod.POST)
	public String addTodo(@RequestParam("form-title") String title, @RequestParam("form-description") String desc,
			Model m) {
		todoService.saveTodo(title, desc);
		m.addAttribute("page", "add");
		return "redirect:dashboard";
	}

	@RequestMapping("/view")
	public String view(Model m) {
//		@SuppressWarnings("unchecked")
//		List<Todo> list = (List<Todo>) context.getAttribute("list");
//		list.add(new Todo());
//		System.out.println(list);
		m.addAttribute("page", "view");
		return "dashboard";
	}

	@RequestMapping("/upload")
	public ModelAndView upload() {
		modelAndView.addObject("page", "upload");
		modelAndView.setViewName("dashboard");
		return modelAndView;
	}

	@RequestMapping(value = { "/upload-save" }, method = RequestMethod.POST)
	public ModelAndView uploadSave(@RequestParam("input-file") MultipartFile file, HttpSession session) {
		String msg = uploadService.uploadFile(file,session);
		modelAndView.addObject("page","upload");
		modelAndView.addObject("message", msg);
		modelAndView.setViewName("dashboard");
		return modelAndView;
	}
}
