package com.lib.bookbrain.model.comm;


import com.lib.bookbrain.constant.Message;
import com.lib.bookbrain.constant.ResponseCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author yunxia
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response {
/**
 * 响应时间
 */
private LocalDateTime exp;
/**
 * 响应码
 */
private Integer code;
/**
 * 响应信息
 */
private String msg;
/**
 * 响应数据
 */
private Object data;

/**
 * 请求成功
 *
 * @param data 数据
 * @return 成功请求的 Response 对象（有数据）
 */
public static Response success(Object data) {
   return new Response(LocalDateTime.now(), ResponseCode.SUCCESS.getCode(), "", data);
}

/**
 * 请求成功
 *
 * @return 成功请求的 Response 对象（无数据）
 */
public static Response success() {
   return success(null);
}

/**
 * 请求失败
 *
 * @param msg 失败相关信息
 * @return 失败请求的 Response 对象
 */
public static Response error(String msg) {
   return new Response(LocalDateTime.now(), ResponseCode.ERROR.getCode(), msg, null);
}

public static Response error(Message message) {
   return error(message.getMsg());
}

public static Response error(Integer code, String message) {
   return new Response(LocalDateTime.now(), code, message, null);
}
}
