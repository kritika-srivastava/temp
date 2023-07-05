package com.stackroute.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.stackroute.model.Customer;
import com.stackroute.repo.CustomerRepositoryImpl;
import com.stackroute.service.CustomerService;

@Configuration
public class BeanConfig {

	@Bean
	public Customer getCustomer() {
		return new Customer();
	}

	@Bean
	public CustomerRepositoryImpl getCustomerRepo() {
		return new CustomerRepositoryImpl();
	}

	@Bean
	public CustomerService getCustomerService() {
		return new CustomerService();
	}

}
