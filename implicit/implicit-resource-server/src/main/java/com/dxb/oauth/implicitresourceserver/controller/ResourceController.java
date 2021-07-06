package com.dxb.oauth.implicitresourceserver.controller;

import com.dxb.oauth.implicitresourceserver.vo.UserVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 */
@RestController
public class ResourceController {

    @GetMapping("/user/{username}")
    public UserVO user(@PathVariable String username) {
        return new UserVO(username, username + "@foxmail.com");
    }
}
