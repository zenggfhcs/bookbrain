package com.lib.bookbrain.constants;

import lombok.Getter;

/**
 * 响应状态枚举
 */
@Getter
public enum ResponseCode {
   /**
    *
    */
   DEFAULT(200),
   /**
    *
    */
   ERROR(-1),;

private final Integer code;

ResponseCode(Integer code) {
   this.code = code;
}
}
