package com.example.springbootwebapplication.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootwebapplication.entity.Customer;
import com.example.springbootwebapplication.impl.CustomerDataService;

import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@RestController
public class CustomerDataController {

	static Logger logger = Logger.getLogger(CustomerDataController.class);

	@Autowired
	private CustomerDataService customerDataService;

	@ApiOperation(value = "Save Customer data")
	@RequestMapping(value = "/customer/save", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<?> saveCustomerData(@RequestBody Customer customer, HttpServletResponse response) {
		JSONObject responseJSON = new JSONObject();
		try {
			customer = customerDataService.saveCustomerData(customer);
			response.setStatus(HttpServletResponse.SC_CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return ResponseEntity.ok(customer);
	}

	@ApiOperation(value = "Find Customer data")
	@RequestMapping(value = "/customer/find/{customerId}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Customer> findCustomerData(@PathVariable(value = "customerId") String customerId, HttpServletResponse response) {
		List<Customer> list = null;
		try {
			list = customerDataService.findCustomerData(customerId);
			response.setStatus(HttpServletResponse.SC_OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@ApiOperation(value = "Update Customer data")
	@RequestMapping(value = "/customer/update", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<?> updatCustomerData(@RequestBody Customer customer, HttpServletResponse response) {
		JSONObject responseJSON = new JSONObject();
		try {
			customer = customerDataService.updatCustomerData(customer);
			response.setStatus(HttpServletResponse.SC_ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
			responseJSON.accumulate("status", "ERROR");
		}
		return ResponseEntity.ok(customer);
	}

	@ApiOperation(value = "Delete Customer data")
	@RequestMapping(value = "/customer/delete/{customerId}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<String> removeCustomerData(@PathVariable(value = "customerId") String customerId, HttpServletResponse response) {
		JSONObject responseJSON = new JSONObject();
		try {

			customerDataService.removeCustomerData(customerId);

			responseJSON.accumulate("status", "SUCCESS");
			response.setStatus(HttpServletResponse.SC_ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
			responseJSON.accumulate("status", "ERROR");
		}

		return ResponseEntity.ok(responseJSON.toString());
	}

	@ApiOperation(value = "Service Check link")
	@RequestMapping(value = "/servicecheck", method = RequestMethod.GET)
	public String servicecheck() {
		return "This is the First Message From Remote SpringBootCURDApp!";
	}
}
