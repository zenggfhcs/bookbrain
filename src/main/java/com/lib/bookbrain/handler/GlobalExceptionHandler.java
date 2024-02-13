package com.lib.bookbrain.handler;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.lib.bookbrain.constant.ResponseInfo;
import com.lib.bookbrain.exception.PermissionMissException;
import com.lib.bookbrain.exception.UpdateErrorException;
import com.lib.bookbrain.model.comm.Response;
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
   return Response.error(ResponseInfo.SQL_EXEC_ERROR);
}

/**
 * jwt error
 *
 * @return 规范返回
 */
@ExceptionHandler(JWTVerificationException.class)
public Response jwtEx() {
   return Response.error(ResponseInfo.TOKEN_ERROR);
}

/**
 * 权限缺失
 *
 * @return 规范返回
 */
@ExceptionHandler(PermissionMissException.class)
public Response missPermission() {
   return Response.error(ResponseInfo.MISS_PERMISSION);
}

/**
 * 更新蔓延抛出异常
 *
 * @return 规范返回
 */
@ExceptionHandler(UpdateErrorException.class)
public Response updateError() {
   return Response.error(ResponseInfo.UPDATE_ERROR);
}

@ExceptionHandler(Exception.class)
public Response error(Exception e) {
   return Response.error(-1, e.getMessage());
}
}