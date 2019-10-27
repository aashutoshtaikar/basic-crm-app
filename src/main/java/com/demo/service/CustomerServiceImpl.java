package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.CustomerRepo;
import com.demo.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepo customerRepo;
	
	@Override
	public List<Customer> getCustomers() {
		return customerRepo.findAll();
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		customerRepo.save(theCustomer);
	}

	@Override
	public Customer getCustomer(int theId) {
		 Optional<Customer> optionalCustomer = customerRepo.findById(theId);
		 if (!optionalCustomer.isPresent()) {
			//throw exception
		 }
		 return optionalCustomer.get();
	}

	@Override
	public void deleteCustomer(int theId) {
		customerRepo.deleteById(theId);
	}

	@Override
	public List<Customer> searchCustomer(String theSearchName) {
		return customerRepo.findByName(theSearchName);
	}

}
