package com.lib.bookbrain.security;

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
private static String getIpAddress(HttpServletRequest request) {
   String[] ips = {
         request.getHeader("x-forwarded-for"),
         request.getHeader("Proxy-Client-IP"),
         request.getHeader("WL-Proxy-Client-IP"),
         request.getHeader("HTTP_CLIENT_IP"),
         request.getHeader("HTTP_X_FORWARDED_FOR"),
         request.getRemoteAddr(),
   };
   for (String ip : ips) {
      if (!isEmpty(ip)) {
         return ip;
      }
   }
   return null;
}

private static boolean isEmpty(String ip) {
   return (ip == null
         || ip.isEmpty()
         || "unknown".equalsIgnoreCase(ip));
}

/**
 * 拦截器
 *
 * @param registry ?
 */
@Override
public void addInterceptors(InterceptorRegistry registry) {
   registry
         .addInterceptor(new Interceptor())
         .addPathPatterns("/**")
         .excludePathPatterns("/users/login", "/users/register", "/token");
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
      response.setHeader("token", token);                   // 更新 token
      return true;                                             // 到具体的服务检查权限
   }
}
}