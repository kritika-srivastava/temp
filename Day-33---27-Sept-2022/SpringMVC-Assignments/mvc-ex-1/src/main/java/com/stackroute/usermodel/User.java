package com.stackroute.usermodel;

import org.springframework.stereotype.Component;

@Component
public class User {

	private String name;

	public User(String name) {
		super();
		this.name = name;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
