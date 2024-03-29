package com.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer>{
	List<Customer> findByName(String theName);
}
