package com.revature.service;

import java.util.List;

import com.revature.model.Customer;

public interface CustomerService {

	boolean registerCustomer(Customer customer);
	
	Customer findUserById(int id);
	
	Customer findUserByName(String name);
	
	List<Customer> getAllCustomers();
}
