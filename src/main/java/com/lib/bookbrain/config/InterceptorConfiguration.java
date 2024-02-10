package com.lib.bookbrain.config;

import com.lib.bookbrain.utils.Jwt;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
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
 * 获取客户端 ip：通过轮询请求所携带的请求头，查询客户端的真实 ip
 *
 * @param request 请求对象
 * @return 客户端 ip
 */
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

/**
 * 判断 ip 字符串是不是空的：空串（""）或者是 "unknown"
 *
 * @param ip 客户端 IP 地址
 * @return 判断结果：为空返回 true
 */
private static boolean isEmpty(String ip) {
   return (ip == null
         || ip.isEmpty()
         || "unknown".equalsIgnoreCase(ip));
}

/**
 * 注册拦截器
 *
 * @param registry 拦截 registry
 */
@Override
public void addInterceptors(InterceptorRegistry registry) {
   registry
         .addInterceptor(new Interceptor())
         .addPathPatterns("/**")    // 添加拦截路径
         .excludePathPatterns(      // 在拦截路径中排除以下路径
               "/users/login",      //
               "/users/register",   //
               "/token"             //
         );
}

/**
 * 内部类实现<br/>
 * 自定义拦截器
 */
public static class Interceptor implements HandlerInterceptor {
   @Override
   public boolean preHandle(@NonNull HttpServletRequest request, HttpServletResponse response, @NonNull Object handler) {
      System.out.println(getIpAddress(request));
      String token = request.getHeader("token");            // 获取 token
      Jwt.decoder(token);                                      // 解析 token，如果解析失败会抛出异常，交由全局异常处理器返回 token 无效
      {                                                        // todo 维护 token 最后使用时间
      
      }
      response.setHeader("token", token);                   // 更新 token
      return true;                                             // 到具体的服务检查权限
   }
}

}
