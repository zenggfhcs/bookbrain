package com.lib.bookbrain.interceptor;

import com.lib.bookbrain.constants.Authority;
import com.lib.bookbrain.model.TokenBody;
import com.lib.bookbrain.model.entity.User;
import com.lib.bookbrain.utils.Jwt;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class Interceptor implements HandlerInterceptor {
@Value("${token.maximum-interval}")
private Integer MAXIMUM_INTERVAL;
@Override
public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
   // 获取 token
   String token = request.getHeader("token");
   // 解析 token
   TokenBody tokenBody = null;
   try {
      tokenBody = Jwt.decoder(token);
      // 维护最后使用时间
      
   } catch (Exception e) {
      // 检查 token 的最后使用时间
      
   }
   
   // 未解析路径，未获取权限类型
   return User.hasAuthority(tokenBody.getAuthority(), Authority.USER_CREATE);
}
}
