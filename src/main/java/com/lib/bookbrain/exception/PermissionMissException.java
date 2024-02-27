package com.lib.bookbrain.exception;

import com.lib.bookbrain.constant.ResponseInfo;
import org.springframework.stereotype.Component;

/**
 * 权限缺失异常
 *
 * @author yunxia
 */
@Component("PermissionMissException")
public class PermissionMissException extends BaseException {
   {
      info = ResponseInfo.MISS_PERMISSION;
   }
}
