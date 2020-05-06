package com.example.springbootwebapplication.controller;

//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//import com.example.springbootwebapplication.controller.CustomerDataController;
//import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
//@WebMvcTest(CustomerDataController.class)
public class TestCustomerDataController {

//	@Autowired
//	private MockMvc mvc;
//
//	@Test
//	public void getAllCustomerAPI() throws Exception {
//		mvc.perform(MockMvcRequestBuilders
//		.get("/customer/find/0")
//		.accept(MediaType.APPLICATION_JSON))
//		//.andDo(print())
//		//.andExpect(status().isOk())
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
