package com.stackroute.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stackroute.config.BeanConfig;
import com.stackroute.model.Customer;
import com.stackroute.service.CustomerService;

@Controller
public class CustomerController {
	ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);

	Customer customer1 = context.getBean(Customer.class);
	CustomerService customerService = context.getBean(CustomerService.class);

	List<Customer> customerlist = new ArrayList<>();

	@RequestMapping("/customers")
	public String getCustomerList(Model model) {
		model.addAttribute("customerList", customerService.customerList());
		return "customers";
	}

	@RequestMapping("/addCustomer")
	public String addCustomer(@ModelAttribute("customer") Customer customer) {
		customerService.addCustomer(customer);
		return "redirect:/customers";
	}

}
