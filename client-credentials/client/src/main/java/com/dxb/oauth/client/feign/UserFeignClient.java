package com.dxb.oauth.client.feign;

import com.dxb.oauth.client.dto.UserDto;
import com.dxb.oauth.client.feign.fallback.UserFeignClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Administrator
 */
@FeignClient(name = "user-feign",url = "http://localhost:8081", fallback = UserFeignClientFallback.class)
public interface UserFeignClient {

    @GetMapping("/user/{username}")
    UserDto getUser(@PathVariable("username") String username);
}
