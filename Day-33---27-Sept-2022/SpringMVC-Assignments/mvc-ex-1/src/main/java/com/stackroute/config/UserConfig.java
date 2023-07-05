package com.stackroute.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.stackroute.usermodel.User;

@Configuration
public class UserConfig {

	@Bean
	public User getUser() {
		return new User("Kritika");
	}

}
