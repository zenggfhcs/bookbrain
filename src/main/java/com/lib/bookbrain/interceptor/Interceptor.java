package com.lib.web.interceptor;

import com.lib.model.TokenBody;
import com.lib.model.User;
import com.lib.utils.Jwt;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class Interceptor implements HandlerInterceptor {
@Override
public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
   // 获取 token
   String token = request.getHeader("token");
   // 解析 token
   TokenBody tokenBody = Jwt.decodeToken(token);
   // 未解析路径，未获取权限类型
   return User.hasAuthority(tokenBody.getAuthority(), 1);
}

@Override
public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {

}

@Override
public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
}
}
