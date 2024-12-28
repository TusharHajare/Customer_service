package com.restapi.customer_service.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.customer_service.pojo.Customer;
import com.restapi.customer_service.repository.CustomerRepo;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepo customerRepo;
	
	public Customer saveCustomer(Customer customer) 
	{
	
		if (customer.getDetails().getSex() == null) 
		{
            throw new IllegalArgumentException("sex must be : M or F");
        }
		if (customer.getDetails().getDob().isAfter(LocalDate.of(2002, 1, 1)))
        {
            throw new IllegalArgumentException("dob must be before : 2002-01-01");
        }
        if (customer.getContractType() == null)
        {
            throw new IllegalArgumentException("contractType must be : FULLTIME or PARTTIME");
        }
        
		return customerRepo.save(customer);
	}
	
	
	public Optional<Customer> getCustomerById(Long id) {
		return customerRepo.findById(id);
	}

}