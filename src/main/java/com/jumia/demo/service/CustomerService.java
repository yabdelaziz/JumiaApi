package com.jumia.demo.service;

import com.jumia.demo.dto.CustomerDto;
import com.jumia.demo.dto.PhoneNoRegex;

import java.util.List;

public interface CustomerService {
    List<CustomerDto> getAllCustomers(PhoneNoRegex country);
}
