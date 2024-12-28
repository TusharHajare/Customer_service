package com.restapi.customer_service.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.customer_service.pojo.Customer;
import com.restapi.customer_service.service.CustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerController 
{
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/create")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) 
	{
		return ResponseEntity.ok().body(customerService.saveCustomer(customer));
	}
	
	
	@GetMapping("/customer/{id}")
	public ResponseEntity<Optional<Customer>> getCustomer(@PathVariable("id") Long id)
	{
		return ResponseEntity.ok().body(customerService.getCustomerById(id));
	}
}
