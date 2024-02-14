package com.lib.bookbrain.exception;

import com.lib.bookbrain.constant.ResponseInfo;
import org.springframework.stereotype.Component;

/**
 * 更新失败异常
 *
 * @author yunxia
 */
@Component("UpdateErrorException")
public class UpdateErrorException extends BaseException {
{
   info = ResponseInfo.ERROR;
}
}
