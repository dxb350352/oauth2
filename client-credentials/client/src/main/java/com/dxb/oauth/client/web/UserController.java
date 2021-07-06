package com.dxb.oauth.client.web;

import com.alibaba.fastjson.JSON;
import com.dxb.oauth.client.dto.UserDto;
import com.dxb.oauth.client.feign.UserFeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 测试调用用户资源服务器的controller，用于测试
 * @author Administrator
 */
@RestController
public class UserController {

    @Resource
    UserFeignClient userClient;

    @GetMapping("/user")
    public String getResourceUser() {
        UserDto testUser = userClient.getUser("test");
        return JSON.toJSONString(testUser);
    }
}
