package com.stackroute.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stackroute.config.UserConfig;
import com.stackroute.usermodel.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class UserController {

	ApplicationContext app = new AnnotationConfigApplicationContext(UserConfig.class);
	User user1 = app.getBean(User.class);

	@RequestMapping("/")
	public String getUser(Model model) {
		model.addAttribute("username", user1.getName());
		return "index";

	}

}
