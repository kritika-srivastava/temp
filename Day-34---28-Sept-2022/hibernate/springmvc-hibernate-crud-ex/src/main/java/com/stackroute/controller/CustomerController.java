package com.stackroute.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stackroute.model.Customer;
import com.stackroute.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/")
	public String gerCustomerPage(Model model) {
		model.addAttribute("customer", new Customer());
		model.addAttribute("customerList",customerService.getCustomerList());
		return "index";
	}
	
	@RequestMapping("/addcustomer")
	public String addcustomer(@ModelAttribute ("customer") Customer customer) {
		customerService.addCustomer(customer);
		return "redirect:/";
	}

}
