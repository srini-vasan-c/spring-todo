package com.model;

public class User {
	private int id;
	private String name;
	private String password;
	private String email;
	private int logged_in;
	public User(int id, String name, String password, String email, int logged_in) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.logged_in = logged_in;
	}
	public User() {
		this.id = 0;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", logged_in="
				+ logged_in + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getLogged_in() {
		return logged_in;
	}
	public void setLogged_in(int logged_in) {
		this.logged_in = logged_in;
	}
}
