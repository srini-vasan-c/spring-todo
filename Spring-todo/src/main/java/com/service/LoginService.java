package com.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.DaoImpl.LoginValidationImpl;
import com.model.User;

public class LoginService {
	@Autowired
	LoginValidationImpl loginValidate;

	public User validateUser(User user) {
		return loginValidate.validateUser(user);
	}
}
