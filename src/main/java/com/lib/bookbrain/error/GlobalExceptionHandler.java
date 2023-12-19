package com.lib.bookbrain.error;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.lib.bookbrain.model.Response;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;

@RestControllerAdvice
public class GlobalExceptionHandler {

/**
 * sql 执行失败异常处理
 *
 * @param se 抛出的异常
 * @return 规范返回
 */
@ExceptionHandler(SQLException.class)
public Response sqlEx(SQLException se) {
   return Response.error("sql执行失败：" + se.getMessage());
}

@ExceptionHandler(JWTVerificationException.class)
public Response jwtEx() {
   return Response.error("token parsing(or create) error");
}

//@ExceptionHandler(Exception.class)
//public Response tokenEx(Exception e) {
//   return Response.error("请求失败:" + e.getMessage());
//}
}