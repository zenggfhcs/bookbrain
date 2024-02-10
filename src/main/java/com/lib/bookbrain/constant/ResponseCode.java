package com.lib.bookbrain.constant;

import lombok.Getter;

/**
 * 响应状态枚举
 *
 * @author yunxia
 */
@Getter
public enum ResponseCode {
   /**
    * default 200
    */
   SUCCESS(200),
   /**
    * error -1
    */
   ERROR(-1),
   ;

private final Integer code;

ResponseCode(Integer code) {
   this.code = code;
}
}
