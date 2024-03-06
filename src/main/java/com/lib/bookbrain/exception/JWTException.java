package com.lib.bookbrain.exception;

import com.lib.bookbrain.constant.ResponseInfo;
import org.springframework.stereotype.Component;

@Component("JWTException")
public class JWTException extends BaseException {
{
	info = ResponseInfo.TOKEN_FAILED;
}
}
