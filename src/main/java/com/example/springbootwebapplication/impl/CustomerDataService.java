package com.example.springbootwebapplication.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootwebapplication.entity.Customer;
import com.example.springbootwebapplication.repository.CustomerDataRepository;
import com.example.springbootwebapplication.utilities.CommonUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Service
public class CustomerDataService {

	@Autowired
	private CustomerDataRepository customerDataRepository;

	public Customer saveCustomerData(Customer customer) {		
		 customer = customerDataRepository.saveAndFlush(customer);
		 return customer;		 
		 
	}

	public List<Customer> findCustomerData(String customerId) {
		List<Customer> customerList = new ArrayList();
		if ("0".equals(customerId)) {
			customerList = customerDataRepository.findAll();
		} else {
			Customer customer = customerDataRepository.findByUserId(Integer.parseInt(customerId));
			customerList.add(customer);
		}
		return customerList;
	}

	public Customer updatCustomerData(Customer customer) {
		return customerDataRepository.saveAndFlush(customer);
	}

	public void removeCustomerData(String customerId) {
		Customer customer = new Customer();
		customer.setUserId(Integer.parseInt(customerId));
		// customer.setStatus("N");

		customerDataRepository.delete(customer);
	}

}
