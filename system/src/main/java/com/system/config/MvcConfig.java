package com.system.config;


import com.yph.resolvers.PmapResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(pmapResolver());
        super.addArgumentResolvers(argumentResolvers);
    }

    @Bean
    public PmapResolver pmapResolver() {
        return new PmapResolver();
    }


//    /**
//     * 添加拦截器
//     */
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        //拦截路径可自行配置多个 可用 ，分隔开
//        registry.addInterceptor(new JwtInterceptor()).addPathPatterns("/**");
//    }


}
