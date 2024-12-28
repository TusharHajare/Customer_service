package com.restapi.customer_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restapi.customer_service.pojo.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {

}
