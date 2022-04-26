package com.DaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.dao.RegistrationDao;
import com.model.User;

public class RegistrationDaoImpl implements RegistrationDao {

	@Autowired
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
//	private JdbcTemplate template;
//	 
//    public RegistrationDaoImpl(DataSource dataSource) {
//    	template = new JdbcTemplate(dataSource);
//    }

	@Override
	public int insertUser(User user) {

		String sql = "insert into users(name,email,password) values('" +
		user.getName() + "','" + user.getEmail() + "','" + user.getPassword() + "')";
		try{  
//			Class.forName("com.mysql.jdbc.Driver");  
//			Connection con=DriverManager.getConnection(  
//			"jdbc:mysql://localhost:3306/tasks","springmvc","springmvc");  
//			//here sonoo is database name, root is username and password  
//			Statement stmt=con.createStatement();  
//			ResultSet rs=stmt.executeQuery(sql);  
			System.out.println(template.update(sql));
			 
//			con.close();  
			}catch(Exception e){ System.out.println(e);} 
		System.out.println(this.template);
		
		
//		String sql = "select * from users";
		return 1;
	}

}
