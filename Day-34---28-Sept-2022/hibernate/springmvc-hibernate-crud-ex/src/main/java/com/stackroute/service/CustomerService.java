package com.stackroute.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.model.Customer;
import com.stackroute.repository.CustomerRepository;

@Service
@Transactional
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepo;
	
	
	public void addCustomer(Customer cust) {
		 customerRepo.add(cust);
	}
	
	public List<Customer> getCustomerList() {
		return customerRepo.customerList();
	}
}
