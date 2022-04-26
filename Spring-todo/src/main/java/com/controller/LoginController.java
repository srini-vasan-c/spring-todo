package com.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.User;
import com.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String register(Model m) {
		m.addAttribute("date", new Date());
		return "login";
	}

	@RequestMapping(value = "/login-validate", method = RequestMethod.POST)
	public String saveRegister(@RequestParam("input-email") String email,
			@RequestParam("input-password") String password) {
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		User user_valid = loginService.validateUser(user);
		String return_view = "";
		System.out.println(user_valid);
		if(user_valid != null && user_valid.getId() >0) {
			return_view = "redirect:/dashboard";
		}else {
			return_view = "redirect:/login";
		}
		return return_view;
	}
}
