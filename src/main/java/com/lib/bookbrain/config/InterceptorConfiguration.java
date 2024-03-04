package com.lib.bookbrain.config;

import com.lib.bookbrain.context.SimpleThreadContext;
import com.lib.bookbrain.interceptor.OptionsInterceptor;
import com.lib.bookbrain.interceptor.RequestInterceptor;
import com.lib.bookbrain.model.comm.TokenInfo;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
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
private SimpleThreadContext<TokenInfo> threadContext;

/**
 * 获取客户端 ip：通过轮询请求所携带的请求头，查询客户端的真实 ip
 *
 * @param request 请求对象
 * @return 客户端 ip
 */
private static String getIpAddress(HttpServletRequest request) {
	String[] ips = {request.getHeader("x-forwarded-for"), request.getHeader("Proxy-Client-IP"),
			request.getHeader("WL-Proxy-Client-IP"), request.getHeader("HTTP_CLIENT_IP"),
			request.getHeader("HTTP_X_FORWARDED_FOR"), request.getRemoteAddr(),};
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
	registry.addInterceptor(new OptionsInterceptor())
			.addPathPatterns("/**");
	registry.addInterceptor(new RequestInterceptor(threadContext))
			.addPathPatterns("/**") // 添加拦截路径
			.excludePathPatterns( // 在拦截路径中排除以下路径
					"/login",
					"/register",
					"/token",
					"/");
}

/**
 * 跨域问题处理
 *
 * @param registry registry
 */
@Override
public void addCorsMappings(CorsRegistry registry) {
	registry.addMapping("/**")
			.allowedOrigins("http://localhost:5173")
			.allowedMethods(CorsConfiguration.ALL)
			.allowedHeaders("*");
}
}
