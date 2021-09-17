package com.jumia.demo.dto;

import java.util.Objects;

import com.jumia.demo.model.Customer;

import lombok.var;

public class CustomerConverter {

    private CustomerConverter() {
    }

    public static Customer convertToCustomer(CustomerDto customerDto) {
        if (Objects.nonNull(customerDto)) {
            var customer = new Customer();
            customer.setId(customerDto.getId());
            customer.setPhone(customerDto.getPhone());
            customer.setName(customerDto.getName());
            return customer;
        }
        return null;
    }

    public static CustomerDto convertToCustomerDto(Customer customer) {
        if (Objects.nonNull(customer)) {
            var customerDto = new CustomerDto();
            customerDto.setId(customer.getId());
            customerDto.setPhone(customer.getPhone());
            customerDto.setName(customer.getName());
            return customerDto;
        }
        return null;
    }
}
