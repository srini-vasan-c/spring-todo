package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DaoImpl.RegistrationDaoImpl;
import com.model.User;

@Service
public class RegistrationService {

	@Autowired
	RegistrationDaoImpl registrationDaoImpl;

	public String registerUser(User user) {
		registrationDaoImpl.insertUser(user);
		return null;

	}
}
