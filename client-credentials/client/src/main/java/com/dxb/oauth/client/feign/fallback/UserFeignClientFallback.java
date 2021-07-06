package com.dxb.oauth.client.feign.fallback;

import com.dxb.oauth.client.dto.UserDto;
import com.dxb.oauth.client.feign.UserFeignClient;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 */
@Component
public class UserFeignClientFallback implements UserFeignClient {
    @Override
    public UserDto getUser(String username) {
        System.err.println("调用接口失败");
        return null;
    }
}
