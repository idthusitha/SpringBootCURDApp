package com.example.springbootwebapplication.controller;

import java.io.IOException;
import java.text.ParseException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.example.springbootwebapplication.BaseIT;

import net.sf.json.JSONObject;

public class TestCustomerDataController extends BaseIT {

	private String responseBody;
	public String responseBodyPOST;
	private String customerId;
	private ResponseEntity<String> response;

	@Test(groups = "regression")
	public void contextLoads() {
		Assert.assertNotNull(getWebController(), "Controller is null");
	}

	@Test(groups = "regression")
	public void addCustomer() throws IOException, ParseException {
		String addURI = "http://localhost:8080/SpringBootCURDApp/customer/save";
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", "application/json");
		headers.add("Content-Type", "application/json");

		logger.info("Add URL :" + addURI);
		String jsonBody = "{\"userName\":\"TEST_USER\",\"salary\":\"123\",\"age\":\"23\",\"status\":\"Y\"}";
		System.out.println("\n\n" + jsonBody);
		HttpEntity<String> entity = new HttpEntity<String>(jsonBody, headers);

		// POST Method to Add New Customer
		response = getRestTemplate().postForEntity(addURI, entity, String.class);
		responseBodyPOST = response.getBody();

		// Write response to file
		responseBody = response.getBody().toString();
		System.out.println("responseBody --->" + responseBody);

		// Get ID from the Response object
		customerId = getCusIdFromResponse(responseBody);
		System.out.println("userId is :" + customerId);

		// Check if the added userId is present in the response body.
		Assert.assertTrue(responseBody.contains(customerId));

		// Check if the status code is 201
		Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
		logger.info("Customer is Added successfully CustomerId:" + customerId);
	}

	public static String getCusIdFromResponse(String json) {
		JSONObject jsonObject = JSONObject.fromObject(json);
		return jsonObject.getString("userId");
	}

	@Test(groups = "regression", dependsOnMethods = "addCustomer", enabled = true)
	public void updateCustomer() throws IOException, ParseException {
		String updateURI = "http://localhost:8080/SpringBootCURDApp/customer/update";
		logger.info("Update URL :" + updateURI);

		String jsonBody = responseBodyPOST;

		jsonBody = jsonBody.replace("TEST_USER", "update_TEST_USER");

		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", "application/json");
		headers.add("Content-Type", "application/json");

		HttpEntity<String> entity = new HttpEntity<String>(jsonBody, headers);

		// PUT Method to Update the existing Customer
		// NOTE that I have Not used restTemplate.put as it's void and we need response for verification
		response = getRestTemplate().exchange(updateURI, HttpMethod.PUT, entity, String.class);
		responseBody = response.getBody().toString();
		System.out.println("Update Response Body :" + responseBody);

		// Check if the updated Customer is present in the response body.
		Assert.assertTrue(responseBody.contains("update_TEST_USER"));

		// Check if the status code is 200
		Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);

		logger.info("Customer Name is Updated successfully CustomerId:" + customerId);

	}

	@Test(groups = "regression", dependsOnMethods = "updateCustomer", enabled = true)
	void getCustomer() throws IOException, ParseException {
		String getURI = "http://localhost:8080/SpringBootCURDApp/customer/find/" + this.customerId;
		logger.info("Get URL :" + getURI);

		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		// GET Method to Get existing Customer
		response = getRestTemplate().getForEntity(getURI, String.class);

		// Write response to file
		responseBody = response.getBody().toString();

		// Suppressing for log diffs
		System.out.println("GET Response Body :" + responseBody);

		// Check if the added Customer ID is present in the response body.
		Assert.assertTrue(responseBody.contains("update_TEST_USER"));

		// Check if the status code is 200
		Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);

		logger.info("Customer is retrieved successfully CustomerId:" + customerId);

	}

	@Test(groups = "regression", dependsOnMethods = "getCustomer", enabled = true)
	public void deleteCustomer() throws IOException, ParseException {
		String delURI = "http://localhost:8080/SpringBootCURDApp/customer/delete/" + this.customerId;
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		// DELETE Method to Delete existing Customer
		response = getRestTemplate().exchange(delURI, HttpMethod.DELETE, entity, String.class);

		// Check if the status code is 204
		Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);

		responseBody = response.getBody();

		Assert.assertEquals(getMessageFromResponse(responseBody), "SUCCESS");

		logger.info("Customer is Deleted successfully CustomerId:" + customerId);
	}

	public static String getMessageFromResponse(String json) {
		String successMessageText = null;
		try {
			JSONObject jsonObject = JSONObject.fromObject(json);
			successMessageText = jsonObject.getString("status");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return successMessageText;
	}

	@AfterTest(groups = "regression")
	public void afterTest() {
		logger.info("Clean up after test execution");
		logger.info("Creating RestTemplate object as Null");
		setRestTemplate(new RestTemplate());
	}
}
