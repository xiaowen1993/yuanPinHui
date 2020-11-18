package com.yph.config;

import com.alibaba.fastjson.JSON;
import com.yph.annotation.PassToken;
import com.yph.entity.Audience;
import com.yph.enun.TipMsgEnum;
import com.yph.modules.user.entity.UserEntity;
import com.yph.util.utli.JwtUtil;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class JwtInterceptor extends HandlerInterceptorAdapter{

    @Autowired
    private Audience audience;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 忽略带JwtIgnore注解的请求, 不做后续token认证校验
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            PassToken jwtIgnore = handlerMethod.getMethodAnnotation(PassToken.class);
            if (jwtIgnore != null) {
                return true;
            }
        }

        if (HttpMethod.OPTIONS == HttpMethod.resolve(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }

        // 获取请求头信息authorization信息
        final String authHeader = request.getHeader("token");

        if (StringUtils.isBlank(authHeader)) {
            throw new Exception(TipMsgEnum.TOKEN_NULL_Excption.getMsg());
        }
        if(audience == null){
            BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
            audience = (Audience) factory.getBean("audience");
        }
        // 验证token是否有效--无效已做异常抛出，由全局异常处理后返回对应信息
        Claims claims = JwtUtil.parseJWT(authHeader);
        String subject = claims.getSubject();
        String userId = JSON.parseObject(subject, String.class);
        request.setAttribute("userId",userId);
        return true;
    }

}
