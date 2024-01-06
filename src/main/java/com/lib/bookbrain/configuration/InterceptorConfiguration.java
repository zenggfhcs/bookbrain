package com.lib.bookbrain.configuration;

import com.lib.bookbrain.interceptor.Interceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器配置类
 */
@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer {
/**
 * 拦截器
 *
 * @param registry 1
 */
@Override
public void addInterceptors(InterceptorRegistry registry) {
   registry.addInterceptor(new Interceptor())
         .excludePathPatterns(
               "users/login", "users/register"
         )
         .addPathPatterns("/**");
}
}