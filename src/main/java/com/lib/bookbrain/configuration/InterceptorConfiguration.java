package com.lib.bookbrain.configuration;

import com.lib.bookbrain.model.TokenBody;
import com.lib.bookbrain.utils.Jwt;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
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
   registry.addInterceptor(new Interceptor()).excludePathPatterns("users/login", "users/register").addPathPatterns("/**");
}

public static class Interceptor implements HandlerInterceptor {
   @Override
   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
      // 获取 token
      String token = request.getHeader("token");
      // 解析 token
      TokenBody tokenBody = Jwt.decoder(token);
      // 维护最后使用时间
      
      response.setHeader("token", token);
      return true;
      // 到具体的服务检查权限
   }
}
}