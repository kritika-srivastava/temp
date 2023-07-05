package com.stackroute.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.stackroute.model.Customer;

@Repository
public interface CustomerRepository {
	List<Customer> customerList();

	void addCustomer(Customer customer);

	boolean deleteCustomer(int customerId);
}
