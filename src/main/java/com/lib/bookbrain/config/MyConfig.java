package com.lib.bookbrain.config;

import com.lib.bookbrain.interceptor.Interceptor;
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