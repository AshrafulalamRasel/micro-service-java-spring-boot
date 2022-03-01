package com.example.employeeservice.config;

import com.example.employeeservice.utils.UuidUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public UuidUtils uuid() {
        return new UuidUtils();
    }
}
