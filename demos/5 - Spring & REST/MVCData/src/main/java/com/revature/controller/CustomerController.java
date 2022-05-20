package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.ClientMessage;
import static com.revature.util.ClientMessageUtil.*;
import com.revature.model.Customer;
import com.revature.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerController {
	
	@Autowired
	private CustomerService cserv;
	
	@GetMapping("/findAllCustomers")
	public @ResponseBody List<Customer> findAllCustomers() {
		// we would have to call the service layer here
		return cserv.getAllCustomers();
	}
	
	@PostMapping(path="/register", consumes= {MediaType.APPLICATION_JSON_VALUE}) 
	public @ResponseBody ClientMessage registerHero(@RequestBody Customer customer) {
		/*
		 * based on whether the insert operation is successful, we will return a specific ClientMessage
		 * when I call the service method.
		 * 
		 * If it is successful, we send a SUCCESS message; if not successful, we send back a message "something went wrong"
		 */
		return cserv.registerCustomer(customer) ? REGISTATION_SUCCESSFUL : SOMETHING_IS_WRONG;
	}
	
	@GetMapping("/customers/{id}")
    public @ResponseBody Customer findUserById(@PathVariable("id") int id) {
        return cserv.findUserById(id);
    }
	
	@GetMapping("/customers/findByName")
    public @ResponseBody Customer findUserByName(@RequestParam String name) {
        return cserv.findUserByName(name);
    }

}
