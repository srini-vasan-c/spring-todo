package com.datasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class DataSourceCon {

	@Autowired
	JdbcTemplate template;
}
