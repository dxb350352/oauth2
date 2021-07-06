package com.dxb.oauth.client.dto;

import lombok.Data;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * @author Administrator
 */
@Data
public class TokenDTO {
    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("refresh_token")
    private String refreshToken;
    @JsonProperty("token_type")
    private String tokenType;
    @JsonProperty("expires_in")
    private String expiresIn;
    @JsonProperty("scope")
    private String scope;
}
