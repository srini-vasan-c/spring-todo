package com.controller;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
		String msg = uploadService.uploadFile(file, session);
		modelAndView.addObject("page", "upload");
		modelAndView.addObject("message", msg);
		modelAndView.setViewName("dashboard");
		return modelAndView;
	}

	@RequestMapping(value = "/files/{file_name}", method = RequestMethod.GET)
	@ResponseBody
	public String getFile(@PathVariable("file_name") String fileName, HttpServletResponse response, HttpSession session)
			throws IOException {
		String path = session.getServletContext().getRealPath("/");
		String fullPath = path + "/WEB-INF/assert/UploadFiles/" + fileName;
		System.out.println("came");
		try {
			// get your file as InputStream
			InputStream is = new FileInputStream(fullPath);
			// copy it to response's OutputStream
			org.apache.commons.io.IOUtils.copy(is, response.getOutputStream());
			response.flushBuffer();
		} catch (IOException ex) {
			System.out.println("Error writing file to output stream. Filename was '{}'" + fileName + ex);
//			throw new RuntimeException("IOError writing file to output stream");
		} catch (Exception ex) {
			System.out.println("Error writing file to output stream. Filename was '{}'" + fileName + ex);
//			throw new RuntimeException("IOError writing file to output stream");
		}
//		response.sendError(500, "Some Error Occured");
		return fullPath;

	}

	@RequestMapping(value="/all-files", method = RequestMethod.GET)
	public ModelAndView listDir(HttpSession session) throws IOException{
		String path = session.getServletContext().getRealPath("/");
		String fullPath = path + "/WEB-INF/assert/UploadFiles/";
		String dir = fullPath;
		Set<String> fileList = new HashSet<>();
	    try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(dir))) {
	        for (Path path1 : stream) {
	            if (!Files.isDirectory(path1)) {
	                fileList.add(path1.getFileName()
	                    .toString());
	            }
	        }
	    }
	    modelAndView.addObject("list",fileList);
		modelAndView.setViewName("all-files");
		return modelAndView;
	}

	@RequestMapping(value = "/hello/{name}", method = RequestMethod.GET)
	public ModelAndView hello(@PathVariable("name") String name, HttpServletResponse response, HttpSession session) {
		String path = session.getServletContext().getRealPath("/");
		String fullPath = path + "/WEB-INF/assert/UploadFiles/" + name;

		modelAndView.addObject("page", "upload");
		modelAndView.addObject("message", fullPath);
		modelAndView.setViewName("dashboard");
		return modelAndView;

	}
}
