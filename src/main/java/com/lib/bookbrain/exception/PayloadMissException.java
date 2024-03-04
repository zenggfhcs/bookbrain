package com.lib.bookbrain.exception;

import com.lib.bookbrain.constant.ResponseInfo;
import org.springframework.stereotype.Component;

/**
 * 请求参数缺失异常
 *
 * @author yunxia
 */
@Component("PayloadMissException")
public class PayloadMissException extends BaseException {
{
	info = ResponseInfo.ERROR;
}
}
