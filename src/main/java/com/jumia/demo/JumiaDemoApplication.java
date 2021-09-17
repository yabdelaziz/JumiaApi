package com.jumia.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages = { "com.jumia.demo" })
public class JumiaDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JumiaDemoApplication.class, args);
    }

    @Bean
    protected RestTemplate getTemplate() {
        return new RestTemplate();
    }
    
}
