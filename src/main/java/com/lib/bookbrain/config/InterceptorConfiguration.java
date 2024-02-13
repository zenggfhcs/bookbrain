package com.lib.bookbrain.config;

import com.lib.bookbrain.context.SimpleThreadContext;
import com.lib.bookbrain.model.comm.TokenBody;
import com.lib.bookbrain.utils.Jwt;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class InterceptorConfiguration implements WebMvcConfigurer {
private SimpleThreadContext<TokenBody> threadContext;

/**
 * 获取客户端 ip：通过轮询请求所携带的请求头，查询客户端的真实 ip
 *
 * @param request 请求对象
 * @return 客户端 ip
 */
private static String getIpAddress(HttpServletRequest request) {
   String[] ips = {request.getHeader("x-forwarded-for"), request.getHeader("Proxy-Client-IP"), request.getHeader("WL-Proxy-Client-IP"), request.getHeader("HTTP_CLIENT_IP"), request.getHeader("HTTP_X_FORWARDED_FOR"), request.getRemoteAddr(),};
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
   return (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip));
}

/**
 * 注册拦截器
 *
 * @param registry 拦截 registry
 */
@Override
public void addInterceptors(InterceptorRegistry registry) {
   registry.addInterceptor(new Interceptor(threadContext))
         .addPathPatterns("/**")    // 添加拦截路径
         .excludePathPatterns(      // 在拦截路径中排除以下路径
               "/users/login",      //
               "/users/register",   //
               "/token",             //
               "/"
         );
}

/**
 * 自定义拦截器
 */
@AllArgsConstructor
static class Interceptor implements HandlerInterceptor {
   private static final String tokenHeader;
   
   static {
      tokenHeader = "token";
   }
   
   private SimpleThreadContext<TokenBody> threadContext;
   
   @Override
   public boolean preHandle(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler) {
      System.out.println(getIpAddress(request));      // todo 凑数
      String token = request.getHeader(tokenHeader);  // 获取 token
      TokenBody body = Jwt.decoder(token);            // 解析 token，如果解析失败会抛出异常，交由全局异常处理器处理
      threadContext.set(body);                        // 记录操作者
      // response.setHeader(HeaderName.TOKEN, token);    // 更新 token
      return true;                                    // 到具体的服务检查权限
   }
   
}

}
