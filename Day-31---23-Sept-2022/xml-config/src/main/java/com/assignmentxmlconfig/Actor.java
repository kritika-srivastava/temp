package com.assignmentxmlconfig;

public class Actor {

	String name;
	String gender;
	int age;

	public Actor(String name, String gender, int age) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Actor [name=" + name + ", gender=" + gender + ", age=" + age + "]";
	}

}
