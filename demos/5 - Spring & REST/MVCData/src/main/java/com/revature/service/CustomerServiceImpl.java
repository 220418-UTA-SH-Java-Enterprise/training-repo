package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Customer;
import com.revature.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository crepo;

	@Override
	public boolean registerCustomer(Customer customer) {
		int pk = crepo.save(customer).getId();
		return (pk > 0) ? true : false;
	}

	@Override
	public Customer findUserById(int id) {
		Customer customer = crepo.findById(id).stream().findFirst().get();
		return customer;
	}

	@Override
	public Customer findUserByName(String name) {
		Customer customer = crepo.findByName(name);
		return customer;
	}

	@Override
	public List<Customer> getAllCustomers() {
		return crepo.findAll();
	}

}
