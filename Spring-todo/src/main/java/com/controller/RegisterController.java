package com.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.User;
import com.service.RegistrationService;

@Controller
public class RegisterController {

	@Autowired
	RegistrationService registrationService;
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register() {
		return "register";
	}

	@RequestMapping(value = "/save-register", method = RequestMethod.POST)
	public String saveRegister(@RequestParam("input-name") String name, @RequestParam("input-email") String email,
			@RequestParam("input-password") String password, @RequestParam("input-check-in") String checkIn) {
		
		User user = new User();
		user.setEmail(email);
		user.setLogged_in(0);
		user.setName(name);
		user.setPassword(password);
		registrationService.registerUser(user);
		String return_view = "";
		if(checkIn == "YES") {
			return_view = "dashboard";
		}else {
			return_view = "register-success";
		}
		return return_view;
	}

}
