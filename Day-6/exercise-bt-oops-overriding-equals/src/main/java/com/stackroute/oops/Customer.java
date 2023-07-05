package com.stackroute.oops;

import java.util.Objects;

public class Customer {

  private int customerId;
  private String name;
  private String email;
  private Address address;

  public Customer() {
    customerId = -1;
    name = null;
    email = null;
    address = new Address();
  }

  public Customer(int customerId, String name, String email, Address address) {
    this.customerId = customerId;
    this.name = name;
    this.email = email;
    this.address = address;
  }

  public int getCustomerId() {
    return customerId;
  }

  public void setCustomerId(int customerId) {
    this.customerId = customerId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public boolean equals(Customer c) {
    if (c == this) {
      return true;
    }
    if (c == null || c.getClass() != this.getClass()) {
      return false;
    }
    Customer customer2 = (Customer) c;
    return (
      (customerId == customer2.customerId) &&
      (
        (name == null && customer2.name == null) ||
        (Objects.equals(name, customer2.name))
      ) &&
      (
        (email == null && customer2.email == null) ||
        (Objects.equals(email, customer2.email))
      ) &&
      (
        (address == null && customer2.address == null) ||
        address.equals(customer2.address)
      )
    );
  }
}
