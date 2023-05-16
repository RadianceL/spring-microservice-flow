package com.olympus.controller;

import com.alibaba.fastjson2.JSON;
import com.olympus.common.user.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
public class AuthenController {
    @Autowired private RedisTemplate<String,String> redisTemplate;
    @Autowired private ReactiveAuthenticationManager authenticationManager;

    /**
     * 自定义登录逻辑
     */
    @PostMapping(value = "/api/login")
    public Mono<String> login(@RequestBody UserInfo user) {
        String username = user.getUsername();
        String password = user.getPassword();
        /**
         * 认证处理逻辑如下：
         * 1. 认证成功后，从获取到的MyUserDetail对象获取User对象，
         * 2. 将User对象使用FastJson2 序列化，并存储到redis中，
         * 3. 最后返回token
         */
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        Mono<Authentication> authenticate = authenticationManager.authenticate(authenticationToken);
        return authenticate.map(auth -> {
            UserInfo principal = (UserInfo) auth.getPrincipal();
            String user1 = principal.getUsername();
            String token = UUID.randomUUID() + "";
            redisTemplate.opsForValue().set(token, JSON.toJSONString(user1));
            return token;
        });

    }
}
