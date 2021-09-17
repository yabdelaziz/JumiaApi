package com.jumia.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDto {

    private Integer id;

    private String name;

    private String phone;

    private String country;

    private String countryCode;
}
