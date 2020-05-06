package com.example.springbootwebapplication.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
	public ResponseEntity<String> saveCustomerData(@RequestBody String requestBody) {
		JSONObject response = new JSONObject();
		try {

			JSONObject json = JSONObject.fromObject(requestBody);

			customerDataService.saveCustomerData(json);

			response.accumulate("status", "SUCCESS");
		} catch (Exception e) {
			e.printStackTrace();
			response.accumulate("status", "ERROR");
		}

		return ResponseEntity.ok(response.toString());
	}

	@ApiOperation(value = "Find Customer data")
	@RequestMapping(value = "/customer/find/{customerId}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> findCustomerData(@PathVariable(value = "customerId") String customerId) {
		JSONArray response = new JSONArray();
		try {

			response = customerDataService.findCustomerData(customerId);

		} catch (Exception e) {
			e.printStackTrace();

			JSONObject responseTemp = new JSONObject();
			responseTemp.accumulate("status", "ERROR");
			response.add(responseTemp);
		}

		return ResponseEntity.ok(response.toString());
	}

	@ApiOperation(value = "Update Customer data")
	@RequestMapping(value = "/customer/update", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<String> updatCustomerData(@RequestBody String requestBody) {
		JSONObject response = new JSONObject();
		try {

			JSONObject json = JSONObject.fromObject(requestBody);

			customerDataService.updatCustomerData(json);

			response.accumulate("status", "SUCCESS");
		} catch (Exception e) {
			e.printStackTrace();
			response.accumulate("status", "ERROR");
		}

		return ResponseEntity.ok(response.toString());
	}

	@ApiOperation(value = "Delete Customer data")
	@RequestMapping(value = "/customer/delete/{customerId}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<String> removeCustomerData(@PathVariable(value = "customerId") String customerId) {
		JSONObject response = new JSONObject();
		try {

			customerDataService.removeCustomerData(customerId);

			response.accumulate("status", "SUCCESS");
		} catch (Exception e) {
			e.printStackTrace();
			response.accumulate("status", "ERROR");
		}

		return ResponseEntity.ok(response.toString());
	}

	@ApiOperation(value = "Service Check link")
	@RequestMapping(value = "/servicecheck", method = RequestMethod.GET)
	public String servicecheck() {
		return "This is the First Message From Remote SpringBootCURDApp!";
	}
}
