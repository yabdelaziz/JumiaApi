package com.jumia.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jumia.demo.dto.CustomerDto;
import com.jumia.demo.repository.CustomerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class CustomerServiceImplTest {
	@Mock
	CustomerRepository customerRepositoryTest;

	@BeforeEach
	void setUp() {
		List<CustomerDto> customerDtos = new ArrayList<CustomerDto>();
		CustomerDto customer1 = new CustomerDto();
		customer1.setId(1);
		customer1.setName("Walid Hammadi");
		customer1.setPhone("(212) 6007989253");
		
		customerDtos.add(customer1);
		
		CustomerDto customer2 = new CustomerDto();
		customer1.setId(1);
		customer1.setName("Yosaf Karrouch");
		customer1.setPhone("(212) 698054317");
		
		customerDtos.add(customer2);
	}
	
//	@Test
//	void testAllCustomersDTOsRetreivedSuccessfully() {
//		List<CustomerDto> customerDtos = new ArrayList<CustomerDto>();
//		customerDtos.add(customerRepositoryTest.findById(0));
//		customerDtos.add(customerRepositoryTest.findById(1));
//		customerDtos.add(customer2);
//		assertEquals(expected, actual);;
//	}
//	
//
//	    @Test
//	    public void testSearchSync() throws Exception {
//
//	        // Mocking service
//	        when(mangaService.getMangasByTitle(any(String.class))).thenReturn(mangas);
//
//	        mockMvc.perform(get("/manga/sync/ken").contentType(MediaType.APPLICATION_JSON))
//	            .andExpect(status().isOk())
//	            .andExpect(jsonPath("$[0].title", is("Hokuto no ken")))
//	            .andExpect(jsonPath("$[1].title", is("Yumekui Kenbun")));
//	    }


}
