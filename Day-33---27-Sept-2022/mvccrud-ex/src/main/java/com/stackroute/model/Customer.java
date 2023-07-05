package com.stackroute.model;

import org.springframework.stereotype.Component;

@Component
public class Customer {

	private int customerid;
	private String custname;
	private String email;

	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(int customerid, String custname, String email) {
		super();
		this.customerid = customerid;
		this.custname = custname;
		this.email = email;
	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public String getCustname() {
		return custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
