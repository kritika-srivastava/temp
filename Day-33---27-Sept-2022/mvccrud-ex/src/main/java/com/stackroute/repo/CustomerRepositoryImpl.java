package com.stackroute.repo;

import com.stackroute.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {

	private List<Customer> customerList = new ArrayList<>();

	@Override
	public List<Customer> customerList() {
		// TODO Auto-generated method stub

		return customerList;
	}

	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}

	@Override
	public void addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		this.customerList.add(customer);

	}

	@Override
	public boolean deleteCustomer(int customerId) {
		this.customerList.removeIf(obj -> obj.getCustomerid() == customerId);
		return true;
	}

}
