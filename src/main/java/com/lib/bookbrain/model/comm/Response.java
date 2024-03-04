package com.lib.bookbrain.model.comm;

import com.lib.bookbrain.constant.ResponseInfo;
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
	return success(data, ResponseInfo.SUCCESS);
}

/**
 * 请求成功
 *
 * @param data data
 * @param info info
 * @return response
 */
public static Response success(Object data, ResponseInfo info) {
	BaseResponseInfo responseInfo = info.getInfo();
	return new Response(LocalDateTime.now(), responseInfo.getCode(), responseInfo.getMessage(), data);
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
 * @param code    code
 * @param message msg
 * @return response
 */
public static Response error(Integer code, String message) {
	return new Response(LocalDateTime.now(), code, message, null);
}

/**
 * 请求失败
 *
 * @param info info
 * @return response
 */
public static Response error(ResponseInfo info) {
	BaseResponseInfo responseInfo = info.getInfo();
	return error(responseInfo.getCode(), responseInfo.getMessage());
}
}
