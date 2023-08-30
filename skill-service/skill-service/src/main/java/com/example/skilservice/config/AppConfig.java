package com.example.skilservice.config;

import com.example.skilservice.utils.UuidUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public UuidUtils uuidUtils(){
        return new UuidUtils();
    }
}
