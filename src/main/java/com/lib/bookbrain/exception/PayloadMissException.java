package com.lib.bookbrain.exception;

import org.springframework.stereotype.Component;

/**
 * 请求参数缺失异常
 *
 * @author yunxia
 */
@Component("PayloadMissException")
public class PayloadMissException extends RuntimeException {
}
