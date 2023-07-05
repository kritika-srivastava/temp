package com.stackroute.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stackroute.config.beanConfig;
import com.stackroute.model.User;
import com.stackroute.service.userService;

@Controller
public class userController {

	ApplicationContext app = new AnnotationConfigApplicationContext(beanConfig.class);

	User user1 = app.getBean(User.class);
	userService userService = app.getBean(userService.class);

	List<User> userList = new ArrayList<>();

	@RequestMapping("/")
	public String getCustomerList(Model model) {
		model.addAttribute("userList", userService.userList());
		return "index";
	}

	@RequestMapping("/addUser")
	public String addUser(@ModelAttribute("user") User user) {
		userService.addUser(user);
		return "redirect:/";
	}
}
