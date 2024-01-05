package com.lib.bookbrain.interceptor;

import com.lib.bookbrain.constants.Authority;
import com.lib.bookbrain.model.TokenBody;
import com.lib.bookbrain.model.entity.User;
import com.lib.bookbrain.utils.Jwt;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class Interceptor implements HandlerInterceptor {
@Override
public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
   // 获取 token
   String token = request.getHeader("token");
   // 解析 token
   TokenBody tokenBody = Jwt.decodeToken(token);
   // 未解析路径，未获取权限类型
   return User.hasAuthority(tokenBody.getAuthority(), Authority.USER_CREATE);
}

@Override
public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {

}

@Override
public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {

}
}
