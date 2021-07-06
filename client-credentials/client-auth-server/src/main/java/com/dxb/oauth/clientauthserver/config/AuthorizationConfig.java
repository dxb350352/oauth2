package com.dxb.oauth.clientauthserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

/**
 * @author Administrator
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        //允许表单提交
        security.allowFormAuthenticationForClients()
                .checkTokenAccess("isAuthenticated()");
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("password_auth_mode")
                .secret(passwordEncoder.encode("123456"))
                // 授权类型，这里选择client_credentials
                .authorizedGrantTypes("client_credentials")
                //请求资源作用域，用于限制客户端与用户无法访问没有作用域的资源
                .scopes("read_user_info")
                //可选，资源id，可以对应一个资源服务器，个人理解为某个资源服务器的所有资源标识
                .resourceIds("resource1")
                .redirectUris("http://localhost:8081/callback");
    }
}
