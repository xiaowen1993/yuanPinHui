package com.yph.filter;

import com.yph.enun.LoginResponse;
import com.yph.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

/**
 * html页面的登陆拦截器
 */
@Component
@Order(-1)
public class HtmlLoginFilter implements WebFilter {


    @Autowired
    private RedisService redisService;


    //判断是否携带 login cookie
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
//        String value = request.getPath().contextPath().value();
        String s = request.getURI().getPath();
        MultiValueMap<String, HttpCookie> cookies = request.getCookies();
        LoginResponse loginResponse = LoginResponse.filterUrl(s);
//        ServerHttpRequest request1 = exchange.getRequest();
        if (loginResponse != null) {
            for (String s1 : loginResponse.getSkipUrl()) {
                if (s.equals(s1)) {
                    return chain.filter(exchange);
                }
            }

            for (Map.Entry<String, List<HttpCookie>> cookie : cookies.entrySet()) {
                String cookieKey = loginResponse.getCookieKey();
                if (cookieKey.equals(cookie.getKey())) {
                    if (redisService.get(cookie.getValue().get(0).getValue()) != null) {
                        return chain.filter(exchange);
                    }
                }
            }
            ServerHttpResponse response = exchange.getResponse();
            response.getHeaders().set("Location", loginResponse.getResponseUrl());
            response.setStatusCode(HttpStatus.SEE_OTHER);
            return response.setComplete();
        }
        return chain.filter(exchange);
    }

}
