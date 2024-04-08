package com.lib.bookbrain.handler;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.lib.bookbrain.constant.ResponseInfo;
import com.lib.bookbrain.exception.BaseException;
import com.lib.bookbrain.model.exchange.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;

/**
 * 全局异常处理器
 *
 * @author yunxia
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

/**
 * sql 执行失败异常处理
 *
 * @return 规范返回
 */
@ExceptionHandler(SQLException.class)
public Response sqlEx() {
	return Response.error(ResponseInfo.SQL_EXEC_FAILED);
}

@ExceptionHandler(TokenExpiredException.class)
public Response tokenExp() {
	return Response.error(ResponseInfo.LOGIN_EXPIRED);
}

/**
 * jwt error
 *
 * @return 规范返回
 */
@ExceptionHandler(JWTVerificationException.class)
public Response jwtEx() {
	return Response.error(ResponseInfo.LOGIN_EXPIRED);
}

@ExceptionHandler(BaseException.class)
public Response ex(BaseException be) {
	return Response.error(be.getInfo());
}

@ExceptionHandler(Exception.class)
public Response error(Exception e) {
	// todo 用于调试
//	log.error(e.toString());
	e.printStackTrace();
	return Response.error(-1, e.getMessage());
}
}
