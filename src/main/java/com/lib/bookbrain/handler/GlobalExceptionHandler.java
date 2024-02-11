package com.lib.bookbrain.handler;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.lib.bookbrain.constant.Message;
import com.lib.bookbrain.exception.PermissionMissException;
import com.lib.bookbrain.exception.UpdateErrorException;
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

/**
 * jwt error
 *
 * @return 规范返回
 */
@ExceptionHandler(JWTVerificationException.class)
public Response jwtEx() {
   return Response.error(Message.TOKEN_ERROR);
}

/**
 * 权限缺失
 *
 * @return 规范返回
 */
@ExceptionHandler(PermissionMissException.class)
public Response missPermission() {
   return Response.error(Message.MISS_PERMISSION);
}

/**
 * 更新蔓延抛出异常
 *
 * @return 规范返回
 */
@ExceptionHandler(UpdateErrorException.class)
public Response updateError() {
   return Response.error(Message.UPDATE_ERROR);
}

// @ExceptionHandler(Exception.class)
// public Response tokenEx(Exception e) {
//    return Response.error("请求失败:" + e.getMessage());
// }
}