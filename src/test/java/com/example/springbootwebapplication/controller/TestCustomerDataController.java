package com.example.springbootwebapplication.controller;

//import static org.hamcrest.Matchers.containsString;
//import static org.mockito.Matchers.any;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import org.junit.jupiter.api.Test;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//import com.example.springbootwebapplication.entity.Customer;
//import com.example.springbootwebapplication.impl.CustomerDataService;
//import com.fasterxml.jackson.databind.ObjectMapper;


//@WebMvcTest(controllers = CustomerDataController.class)
public class TestCustomerDataController {

//	@Autowired
//	private MockMvc mvc;
//	
//	@Autowired
//	private ObjectMapper objectMapper;
//
//	@MockBean
//	private CustomerDataService customerDataService;

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
//	public void should_CreateAccount_When_ValidRequest() throws Exception {
//		when(customerDataService.saveCustomerData(any(Customer.class))).thenReturn(12345);
//
//		mvc.perform(MockMvcRequestBuilders
//		.post("/customer/save")
//       .contentType(MediaType.APPLICATION_JSON)
//       .content(loadCustomer()) 
//       .accept(MediaType.APPLICATION_JSON))
//       //.andExpect(status().isCreated())
//       //.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
//       .andExpect(MockMvcResultMatchers.header().string("Location", "/customer/find/12345"))
//       .andExpect(MockMvcResultMatchers.jsonPath("$.userId").value("12345")) 
//       .andExpect(MockMvcResultMatchers.jsonPath("$.userName").value("TEST_USER"))
//       .andExpect(MockMvcResultMatchers.jsonPath("$.salary").value("100")); 
//
//	}
//	@Test
//	public void getCustomerByIdAPI() throws Exception {
//		/* setup mock */
//		Customer customer = new Customer(Integer.parseInt("1"), "TEST_USER", "35","50000","Y");		
//	    when(customerDataService.findCustomerData("1").get(0)).thenReturn(customer);
//		 
//		mvc.perform(MockMvcRequestBuilders.get("/customer/find/{customerId}", 1).accept(MediaType.APPLICATION_JSON))
//		.andDo(print())		
//		.andExpect(status().isOk())
//		.andExpect(MockMvcResultMatchers.jsonPath("[0].userId").value(1));
//	}
//
//	@Test
//	public void createCustomerAPI() throws Exception {
//		mvc.perform(MockMvcRequestBuilders
//		.post("/customer/save")
//		.content(loadCustomer())
//		.contentType(MediaType.APPLICATION_JSON)
//		.accept(MediaType.APPLICATION_JSON))
//		.andExpect(status()
//		.isCreated())
//		.andExpect(MockMvcResultMatchers.jsonPath("$.userId").exists());
//	}
//	@Test
//	public void deleteEmployeeAPI() throws Exception {
//	 // mvc.perform( MockMvcRequestBuilders.delete("/customer/delete/{id}", 1))
//	//   .andExpect(status().isAccepted());
//	}
//
	private String loadCustomer() {
		return " {\"userName\": \"TEST_USER\", \"age\": \"40\", \"salary\": \"100\", \"status\": \"Y\" }";
	}
}
