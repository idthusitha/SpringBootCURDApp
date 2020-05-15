package com.example.springbootwebapplication.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.testng.annotations.Test;

import com.example.springbootwebapplication.BaseIT;

import net.sf.json.JSONObject;

public class TestMockCustomerDataController extends BaseIT {
	
	private String userId = "";
	
	@Test(groups = "regression")
	public void testAddCustomer() throws Exception {
		MvcResult result = getMockMvc().perform(MockMvcRequestBuilders
		.post("/customer/save")
		.content(loadCustomer())
		.contentType(MediaType.APPLICATION_JSON)
		.accept(MediaType.APPLICATION_JSON))
		.andDo(MockMvcResultHandlers.print())
		.andExpect(status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.userId").exists())
		.andReturn();
		
		String content = result.getResponse().getContentAsString();		
		userId = JSONObject.fromObject(content).getString("userId");
		
	}
	
	@Test(groups = "regression" , dependsOnMethods = "testAddCustomer")
	public void testLoadCustomer() throws Exception {
		MvcResult result = getMockMvc().perform(get("/customer/find/"+userId))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(status().isOk())				
				.andExpect(content().contentType("application/json"))
				.andExpect(jsonPath("[0].userName").value("TEST_USER"))
				.andExpect(jsonPath("[0].age").value("40"))
				.andExpect(jsonPath("[0].salary").value("1000"))
				.andExpect(jsonPath("[0].status").value("Y"))
				.andReturn();

	}
	
	@Test(groups = "regression", dependsOnMethods = "testLoadCustomer")
	public void testDeleteCustomer() throws Exception {
		getMockMvc().perform(MockMvcRequestBuilders
		.delete("/customer/delete/+"+userId)
		.content(loadCustomer())
		.contentType(MediaType.APPLICATION_JSON)
		.accept(MediaType.APPLICATION_JSON))
		.andDo(MockMvcResultHandlers.print())
		.andExpect(status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.status").exists());
	}
	
	private String loadCustomer() {
		return " {\"userName\": \"TEST_USER\", \"age\": \"40\", \"salary\": \"1000\", \"status\": \"Y\" }";
	}
}
