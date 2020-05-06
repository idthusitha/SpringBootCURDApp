package com.example.springbootwebapplication.controller;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.springbootwebapplication.impl.CustomerDataService;
import com.fasterxml.jackson.databind.ObjectMapper;


@WebMvcTest(controllers = CustomerDataController.class)
public class TestCustomerDataController {

	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper objectMapper;

	@MockBean
	private CustomerDataService customerDataService;

//	@Test
//	public void getAllCustomerAPI() throws Exception {
//		mvc.perform(MockMvcRequestBuilders
//		.get("/customer/find/0")
//		.accept(MediaType.APPLICATION_JSON))
//		.andDo(print())
//		.andExpect(status().isOk())
//		.andExpect(MockMvcResultMatchers.jsonPath("$.customer").exists())
//		.andExpect(MockMvcResultMatchers.jsonPath("$.customer[*].id").isNotEmpty());
//	}
//
//	@Test
//	public void getCustomerByIdAPI() throws Exception {
//		mvc.perform(MockMvcRequestBuilders.get("/customer/find/{id}", 1).accept(MediaType.APPLICATION_JSON))
//		// .andDo(print())
//		// .andExpect(status().isOk())
//		.andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1));
//	}
//
//	@Test
//	public void createCustomerAPI() throws Exception {
//		mvc.perform(MockMvcRequestBuilders
//		.post("/customer/save")
//		.content(loadCustomer())
//		.contentType(MediaType.APPLICATION_JSON)
//		.accept(MediaType.APPLICATION_JSON))
//		//.andExpect(status()
//		//.isCreated())
//		.andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
//	}
//	@Test
//	public void deleteEmployeeAPI() throws Exception {
//	 // mvc.perform( MockMvcRequestBuilders.delete("/customer/delete/{id}", 1))
//	//   .andExpect(status().isAccepted());
//	}
//
//	private String loadCustomer() {
//		return " {\"userName\": \"test user\", \"age\": \"40\", \"salary\": \"100\", \"status\": \"Y\" }";
//	}
}
