package com.stackroute.userRepository;

import java.util.ArrayList;
import java.util.List;

import com.stackroute.model.User;

public class userRepositoryImplementation implements userRepository {

	private List<User> userList = new ArrayList<>();

	@Override
	public List<User> userList() {
		return this.userList;
	}

	@Override
	public void addUser(User user) {
		this.userList.add(user);

	}

}
