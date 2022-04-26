package com.service;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

	public void saveTodo(String title, String desc) {
		System.out.println(title+desc);
		
	}

}
