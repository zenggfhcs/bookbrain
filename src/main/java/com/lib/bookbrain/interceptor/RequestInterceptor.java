package com.lib.bookbrain.interceptor;

import com.lib.bookbrain.constant.Header;
import com.lib.bookbrain.context.SimpleThreadContext;
import com.lib.bookbrain.pojo.TokenInfo;
import com.lib.bookbrain.security.Jwt;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * 自定义拦截器
 */
@AllArgsConstructor
public class RequestInterceptor implements HandlerInterceptor {

private SimpleThreadContext<TokenInfo> threadContext;

@Override
public boolean preHandle(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response,
								 @NonNull Object handler) {
	String token = request.getHeader(Header.TOKEN); // 获取 token
	TokenInfo _info = Jwt.decoder(token); // 解析 token，如果解析失败会抛出异常，交由全局异常处理器处理
	threadContext.set(_info); // 记录操作者
	return true; // 放行
}

}
