package com.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yph.util.JSONUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConfiguration {

    @Bean
    public ObjectMapper genericObjectMapper(){
        return JSONUtils.buildMapperWithDefaultConfigure(null);
    }

}
