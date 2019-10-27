package com.demo.service;

import java.util.List;

import com.demo.model.Customer;

public interface CustomerService {
	public List<Customer> getCustomers();
	public void saveCustomer(Customer theCustomer);
	public Customer getCustomer(int theId);
	public void deleteCustomer(int theId);
	public List<Customer> searchCustomer(String theSearchName);
}
