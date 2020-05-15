package com.example.springbootwebapplication.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.testng.annotations.Test;

import com.example.springbootwebapplication.BaseIT;

public class TestMockCustomerDataController extends BaseIT {

	@Test(groups = "regression")
	public void testLoadCustomer() throws Exception {
		getMockMvc().perform(get("/customer/find/1"))
				//.andDo(print())
				.andExpect(status().isOk())				
				.andExpect(content().contentType("application/json"))
				.andExpect(jsonPath("[0].userName").value("Thusitha"))
				.andExpect(jsonPath("[0].age").value("40"))
				.andExpect(jsonPath("[0].salary").value("100"))
				.andExpect(jsonPath("[0].status").value("Y"));

	}
}
