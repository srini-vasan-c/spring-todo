package com.DaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.dao.LoginDao;
import com.model.User;

public class LoginValidationImpl implements LoginDao {
	@Autowired
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@SuppressWarnings("deprecation")
	@Override
	public User validateUser(User user) {
		String sql = "select id,name,email,password,logged_in from users where email='"+ user.getEmail()
				+ "' and password = '" + user.getPassword() + "'";
		User list_user = null;
		try { 
			list_user = template.query(sql, new ResultSetExtractor<User>() {
				 
		        @Override
		        public User extractData(ResultSet rs) throws SQLException,
		                DataAccessException {
		            if (rs.next()) {
		                User user = new User();
		                user.setId(rs.getInt("id"));
		                user.setName(rs.getString("name"));
		                user.setEmail(rs.getString("email"));
		                user.setPassword(rs.getString("password"));
		                user.setLogged_in(rs.getInt("logged_in"));
		                return user;
		            }
		 
		            return null;
		        }
		 
		    });
		} catch (Exception e) {
			System.out.println(e);
		}
		return list_user;
	}

}
