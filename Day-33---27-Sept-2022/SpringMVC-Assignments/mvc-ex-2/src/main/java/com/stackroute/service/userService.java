package com.stackroute.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.model.User;
import com.stackroute.userRepository.userRepository;

@Service
public class userService {

	@Autowired
	private userRepository userRepo;

	public List<User> userList() {
		return userRepo.userList();
	}

	public void addUser(User user) {
		this.userRepo.addUser(user);

	}
}
