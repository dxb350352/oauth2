package com.dxb.oauth.client.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 */
@Component
@ConfigurationProperties(prefix = "uaa")
@Data
public class UaaProperties {
    private String clientId;
    private String clientSecret;
    private String tokenEndpoint;
}
