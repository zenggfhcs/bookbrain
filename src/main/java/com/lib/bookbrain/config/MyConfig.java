package com.lib.web.config;

import com.lib.web.interceptor.Interceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyConfig implements WebMvcConfigurer {

@Override
public void addInterceptors(InterceptorRegistry registry) {
   registry.addInterceptor(new Interceptor()).addPathPatterns("/**");
}
}