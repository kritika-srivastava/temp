package com.stackroute.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.model.Customer;
import com.stackroute.repo.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepo;

	public List<Customer> customerList() {
		return customerRepo.customerList();
	}

	public void addCustomer(Customer customer) {
		customerRepo.addCustomer(customer);
	}

	public boolean deleteCustomer(int customerId) {
		return customerRepo.deleteCustomer(customerId);
		
	}

}
