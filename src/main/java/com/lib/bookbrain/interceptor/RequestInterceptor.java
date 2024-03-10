package com.lib.bookbrain.interceptor;

import com.lib.bookbrain.constant.Header;
import com.lib.bookbrain.context.SimpleThreadContext;
import com.lib.bookbrain.exception.JWTException;
import com.lib.bookbrain.exception.PermissionMissException;
import com.lib.bookbrain.pojo.TokenInfo;
import com.lib.bookbrain.security.Jwt;
import com.lib.bookbrain.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * 自定义拦截器
 */
@Component
@AllArgsConstructor
public class RequestInterceptor implements HandlerInterceptor {

private final SimpleThreadContext<TokenInfo> threadContext;

private final UserService userService;

/**
 * 拦截后，1：获取请求头里面的 token；2.解析 token；3.权限检查
 *
 * @param request  r
 * @param response r
 * @param handler  h
 * @return true or false
 */
@Override
public boolean preHandle(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler) {
	String token = request.getHeader(Header.TOKEN);
	TokenInfo _info;
	try {
		_info = Jwt.decoder(token);
	} catch (Exception e) {
		// todo 过期的话 要怎么做
		e.printStackTrace();
		throw new JWTException();
	}

	String _url = request.getRequestURI();
	if (userService.check(_info.getAud(), _url) == 0) {
		throw new PermissionMissException();
	}

	threadContext.set(_info); // 记录操作者
	return true; // 放行
}

}
