package com.restapi.customer_service.pojo;

import java.util.ArrayList;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
public class Customer 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String accountType;
	private String contractType;
	
	private ArrayList<String> businessRequirement;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = CustomerDetails.class)
	@JoinColumn(name="detailsId", referencedColumnName = "id")
	private CustomerDetails details;

	public Customer() {
		super();
	}
	
	public Customer(String name, String accountType, String contractType,
			ArrayList<String> businessRequirement, CustomerDetails details) {
		super();
		this.name = name;
		this.accountType = accountType;
		this.contractType = contractType;
		this.businessRequirement = businessRequirement;
		this.details = details;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	public String getContractType() {
		return contractType;
	}
	public void setContractType(String contractType) {
		this.contractType = contractType;
	}
	
	public ArrayList<String> getBusinessRequirement() {
		return businessRequirement;
	}
	public void setBusinessRequirement(ArrayList<String> businessRequirement) {
		this.businessRequirement = businessRequirement;
	}

	public CustomerDetails getDetails() {
		return details;
	}
	public void setDetails(CustomerDetails details) {
		this.details = details;
	}
}