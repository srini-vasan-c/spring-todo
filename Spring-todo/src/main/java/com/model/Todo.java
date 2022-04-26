package com.model;

public class Todo {
	private String title;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	private String description;
	@Override
	public String toString() {
		return "Title=" + title + ", Description=" + description ;
	}
	public Todo() {
		// TODO Auto-generated constructor stub
	}
}
