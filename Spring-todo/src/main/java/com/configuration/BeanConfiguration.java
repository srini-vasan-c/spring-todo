package com.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.service.TodoService;

@Configuration
@ComponentScan("TodoService")
public class BeanConfiguration {

	@Bean
	public TodoService todoService() {
		return new TodoService();
	}
}
