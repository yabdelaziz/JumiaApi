package com.jumia.demo.controller;

import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.jumia.demo.dto.CustomerDto;
import com.jumia.demo.dto.PhoneNoRegex;
import com.jumia.demo.service.CustomerServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerControllerTest {

	MockMvc mockMvc;

    @Autowired
    protected WebApplicationContext wac;
    
    @Autowired
    CustomerController customerController;

    @MockBean
    CustomerServiceImpl customerService;
    
    private List<CustomerDto> customerDtos;
    
	@Before
	public void setUp() throws Exception{
		this.mockMvc = MockMvcBuilders.standaloneSetup(this.customerController).build();
		customerDtos = new ArrayList<CustomerDto>();
		CustomerDto customer1 = new CustomerDto();
		customer1.setId(1);
		customer1.setName("Walid Hammadi");
		customer1.setPhone("(212) 698054317");
		customerDtos.add(customer1);

		CustomerDto customer2 = new CustomerDto();
		customer2.setId(0);
		customer2.setName("Yosaf Karrouch");
		customer2.setPhone("(212) 6007989253");
		
		customerDtos.add(customer2);
			
	}
	
	@Test
    public void testGetCustomersByCountry() throws Exception {

        // Mocking service
		Mockito.when(customerService.getAllCustomers(any(PhoneNoRegex.class))).thenReturn(customerDtos);

        mockMvc.perform(get("/api/customers/?country=MOROCCO").contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].name", is("Walid Hammadi")))
            .andExpect(jsonPath("$[1].name", is("Yosaf Karrouch")));
    }


	

}
