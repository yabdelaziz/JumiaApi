package com.jumia.demo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.jumia.demo.dto.CustomerDto;
import com.jumia.demo.dto.PhoneNoRegex;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceImplTest {

	@Autowired
	CustomerService customerService;

	@MockBean
	private RestTemplate template;
	
	@Test
    public void testgetAllCustomersByCountry() throws IOException {

        CustomerDto customerDto = new CustomerDto();
        // Mocking remote service
        when(template.getForEntity(any(String.class), any(Class.class))).thenReturn(new ResponseEntity(customerDto, HttpStatus.OK));
        // I search for goku but system will use mocked response containing only ken, so I can check that mock is used.
        List<CustomerDto> customersByTitle = customerService.getAllCustomers(PhoneNoRegex.MOROCCO);
        assertThat(customersByTitle).isNotNull()
            .isNotEmpty()
            .allMatch(p -> p.getPhone()
                .contains("212"));
    }
}
