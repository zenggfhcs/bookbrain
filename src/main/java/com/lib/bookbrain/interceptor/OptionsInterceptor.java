package com.lib.bookbrain.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import org.springframework.web.servlet.HandlerInterceptor;

public class OptionsInterceptor implements HandlerInterceptor {
@Override

public boolean preHandle(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler) {
   if (request.getMethod().equals("OPTIONS")) {
      // 对于OPTIONS请求，直接返回成功
      response.setStatus(HttpServletResponse.SC_OK);
      return false;
   }
   return true;
}
}
