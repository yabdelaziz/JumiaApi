package com.jumia.demo.controller;

import com.jumia.demo.dto.CustomerDto;
import com.jumia.demo.dto.PhoneNoRegex;
import com.jumia.demo.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(path = "/api/customers")
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {
    final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    @ResponseStatus(OK)
    public List<CustomerDto> getAllCustomers(@RequestParam(required = false) PhoneNoRegex country) {
        return customerService.getAllCustomers(country);
    }
}
