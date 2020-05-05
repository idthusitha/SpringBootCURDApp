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

	public void saveCustomerData(JSONObject json) {
		Customer customer = new Customer();
		customer.setUserName(json.getString("userName"));
		customer.setAge(json.getString("age"));
		customer.setSalary(json.getString("salary"));
		customer.setStatus("Y");

		customerDataRepository.saveAndFlush(customer);

	}

	public JSONArray findCustomerData(String customerId) {
		List<Customer> customerList = new ArrayList();
		JSONArray array = new JSONArray();

		if ("0".equals(customerId)) {
			customerList = customerDataRepository.findAll();
		} else {
			Customer customer = customerDataRepository.findOne(Integer.parseInt(customerId));
			customerList.add(customer);
		}

		if (customerList.size() > 0) {
			for (Customer customer : customerList) {
				array.add(CommonUtils.getInstance().objectToJSON(customer));
			}
		}
		return array;
	}

	public void updatCustomerData(JSONObject json) {
		Customer customer = new Customer();
		customer.setId(json.getInt("id"));
		customer.setUserName(json.getString("userName"));
		customer.setAge(json.getString("age"));
		customer.setSalary(json.getString("salary"));
		customer.setStatus("Y");

		customerDataRepository.saveAndFlush(customer);

	}

	public void removeCustomerData(String customerId) {
		Customer customer = new Customer();
		customer.setId(Integer.parseInt(customerId));
		//customer.setStatus("N");

		customerDataRepository.delete(customer);
	}

}
