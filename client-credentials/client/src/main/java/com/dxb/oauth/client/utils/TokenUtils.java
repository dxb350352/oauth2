package com.dxb.oauth.client.utils;

import com.dxb.oauth.client.dto.TokenDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.Map;
import java.util.Objects;

/**
 * @author Administrator
 */
@Component
public class TokenUtils {

    @Resource(name = "tokenTemplate")
    private RestTemplate tokenTemplate;

    public String getBearerTokenByClientCredentials(String clientId, String clientSecret, String tokenEndpoint) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setBasicAuth(clientId, clientSecret);
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "client_credentials");
        RequestEntity<MultiValueMap<String, String>> requestEntity
                = new RequestEntity<>(params, httpHeaders, HttpMethod.POST, URI.create(tokenEndpoint));
        ResponseEntity<Map> exchange = tokenTemplate.exchange(requestEntity, Map.class);
        if (exchange.getStatusCode().is2xxSuccessful()) {
            return "Bearer " + Objects.requireNonNull(exchange.getBody().get("access_token"));
        } else {
            return "";
        }
    }

}
