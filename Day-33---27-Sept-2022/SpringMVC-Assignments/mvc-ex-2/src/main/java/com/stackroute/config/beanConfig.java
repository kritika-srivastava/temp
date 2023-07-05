package com.stackroute.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.stackroute.model.User;
import com.stackroute.service.userService;
import com.stackroute.userRepository.userRepositoryImplementation;

@Configuration
public class beanConfig {

	@Bean
	public User getUser() {
		return new User();
	}

	@Bean
	public userRepositoryImplementation getUserRepo() {
		return new userRepositoryImplementation();
	}

	@Bean
	public userService getUserService() {
		return new userService();
	}

}
