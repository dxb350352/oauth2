package com.dxb.oauth.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Administrator
 */
@Configuration
public class Config {

    @Bean("tokenTemplate")
    public RestTemplate tokenTemplate() {
        return new RestTemplate();
    }
}
