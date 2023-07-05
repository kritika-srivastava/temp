package com.stackroute.repository;

import java.util.List;

import com.stackroute.model.Customer;

public interface CustomerRepository {
	
	public void add(Customer customer);
	public List<Customer> customerList();

}
