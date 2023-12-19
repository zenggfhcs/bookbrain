package com.lib.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

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
   return new Response(LocalDateTime.now(), 0, "success", data);
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
 * @param message 失败相关信息
 * @return 失败请求的 Response 对象
 */
public static Response error(String message) {
   return new Response(LocalDateTime.now(), -1, message, null);
}

public static Response error(Integer code, String message) {
   return new Response(LocalDateTime.now(), code, message, null);
}
}
