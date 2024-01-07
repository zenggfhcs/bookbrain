package com.lib.bookbrain.exception;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.lib.bookbrain.constants.Message;
import com.lib.bookbrain.model.Response;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;

/**
 * 全局异常处理器
 *
 * @author yunxia
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

/**
 * sql 执行失败异常处理
 *
 * @return 规范返回
 */
@ExceptionHandler(SQLException.class)
public Response sqlEx() {
   return Response.error(Message.SQL_RUN_ERROR);
}

@ExceptionHandler(JWTVerificationException.class)
public Response jwtEx() {
   return Response.error(Message.TOKEN_ERROR);
}

@ExceptionHandler(MissPermissionException.class)
public Response missPermission() {
   return Response.error(Message.MISS_PERMISSION);
}

@ExceptionHandler(UpdateErrorException.class)
public Response updateError() {
   return Response.error(Message.UPDATE_ERROR);
}

// @ExceptionHandler(Exception.class)
// public Response tokenEx(Exception e) {
//    return Response.error("请求失败:" + e.getMessage());
// }
}