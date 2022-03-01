package com.example.departmentservice.config;

import com.example.departmentservice.utils.UuidUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public UuidUtils uuidUtils(){
        return new UuidUtils();
    }
}
