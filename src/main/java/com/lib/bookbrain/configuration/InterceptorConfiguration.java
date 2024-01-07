package com.lib.bookbrain.configuration;

import com.lib.bookbrain.utils.Jwt;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器配置类
 *
 * @author yunxia
 */
@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer {
/**
 * 拦截器
 *
 * @param registry ?
 */
@Override
public void addInterceptors(InterceptorRegistry registry) {
   registry.addInterceptor(new Interceptor()).excludePathPatterns("users/login", "users/register").addPathPatterns("/**");
}

/**
 * 自定义实现 拦截器
 */
public static class Interceptor implements HandlerInterceptor {
   @Override
   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
      String token = request.getHeader("token");            // 获取 token
      Jwt.decoder(token);                                      // 解析 token，如果解析失败会抛出异常，交由全局异常处理器返回 token 无效
      {                                                        // 维护 token 最后使用时间
      
      }
      response.setHeader("token", token);                   // token 更新
      return true;                                             // 到具体的服务检查权限
   }
}
}