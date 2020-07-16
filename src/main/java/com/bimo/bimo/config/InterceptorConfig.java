package com.bimo.bimo.config;

import com.bimo.bimo.interceptor.AuthenticationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;


@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {

//    @Bean
//    public AuthenticationInterceptor getAuthenticationInterceptor() {
//        return new AuthenticationInterceptor();
//    }

    @Resource
    public AuthenticationInterceptor authenticationInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authenticationInterceptor).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

}
