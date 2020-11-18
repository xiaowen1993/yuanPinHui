package com.yph.controller;


import com.yph.param.RedisParamenter;
import com.yph.redis.service.RedisService;
import com.yph.serviceClient.AdminServiceClient;
import com.yph.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseCookie;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    AdminServiceClient adminServiceClient;

    @Autowired
    RedisService redisService;

    @RequestMapping(value = "/login/adminLogin",method = RequestMethod.POST)
    public R test(String adminName,String adminPassword,ServerHttpResponse response){
        R login = adminServiceClient.login(adminName, adminPassword);
        int code = Integer.parseInt(login.get("code").toString());
        if (code==0){
            Map map=(Map) login.get("data");
            ResponseCookie build = ResponseCookie.from(RedisParamenter.ADMIN_LOING_USER_REDIS_KEY, map.get("id").toString()).path("/").build();
            response.addCookie(build);
        }

        return login;
    }

}
