package com.lib.bookbrain.interceptor;

import com.auth0.jwt.exceptions.TokenExpiredException;
import com.lib.bookbrain.constant.Header;
import com.lib.bookbrain.context.SimpleThreadContext;
import com.lib.bookbrain.dao.TokenAccessRecordMapper;
import com.lib.bookbrain.exception.JWTException;
import com.lib.bookbrain.exception.PermissionMissException;
import com.lib.bookbrain.model.entity.TokenAccessRecord;
import com.lib.bookbrain.model.pojo.TokenInfo;
import com.lib.bookbrain.security.Jwt;
import com.lib.bookbrain.service.UserService;
import com.lib.bookbrain.utils.LogUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 自定义拦截器
 */
@Component
@AllArgsConstructor
public class RequestInterceptor implements HandlerInterceptor {

private final SimpleThreadContext<TokenInfo> threadContext;

private final UserService userService;

private final TokenAccessRecordMapper tokenMapper;

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
	String _token = request.getHeader(Header.TOKEN);
	TokenInfo _info;
	try {
		_info = Jwt.decoder(_token);
	} catch (TokenExpiredException te) {
		// token 过期的处理
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		throw te;
	} catch (Exception e) {
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		LogUtils.log(e.getMessage());
		throw new JWTException();
	}

	String _url = request.getRequestURI();
	System.out.println(request.getMethod() + _url);
	if (userService.checkPermission(_info.getAud(), _url) == 0) {
		throw new PermissionMissException();
	}

	// 记录操作者
	threadContext.set(_info);

	// 记录 token 使用
	TokenAccessRecord tur = TokenAccessRecord.builder()
			.userId(_info.getAud())
			.token(_token)
			.build();
	tokenMapper.insert(tur);

	return true; // 放行
}

@Override
public void postHandle(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler, ModelAndView modelAndView) {
}

@Override
public void afterCompletion(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler, Exception ex) {
}
}
