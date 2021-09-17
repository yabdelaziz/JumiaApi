package com.jumia.demo.service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.jumia.demo.dto.CustomerConverter;
import com.jumia.demo.dto.CustomerDto;
import com.jumia.demo.dto.PhoneNoRegex;
import com.jumia.demo.repository.CustomerRepository;

import lombok.var;

@Service
public class CustomerServiceImpl implements CustomerService {
    final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerDto> getAllCustomers(PhoneNoRegex country) {
        return customerRepository.findAll()
                .stream()
                .map(CustomerConverter::convertToCustomerDto)
                .filter(Objects::nonNull)
                .peek(customerDto -> Arrays.stream(PhoneNoRegex.values()).forEach(phoneNoRegex -> {
                    var pattern = Pattern.compile(phoneNoRegex.getRegex());
                    var matcher = pattern.matcher(customerDto.getPhone());
                    if (matcher.matches()) {
                        customerDto.setCountry(phoneNoRegex.name());
                        customerDto.setCountryCode(phoneNoRegex.getCountryCode());
                    }
                }))
                .filter(customerDto -> Objects.isNull(country) ||
                        (Objects.nonNull(customerDto.getCountry())
                                && customerDto.getCountry().equals(country.name())))
                .collect(Collectors.toList());
    }
}
