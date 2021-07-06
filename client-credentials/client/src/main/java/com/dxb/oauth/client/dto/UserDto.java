package com.dxb.oauth.client.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Administrator
 */
@Data
@AllArgsConstructor
public class UserDto {
    private String username;
    private String email;

}
