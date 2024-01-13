package com.lib.bookbrain.constants;

import lombok.Getter;

/**
 * 响应状态枚举
 *
 * @author yunxia
 */
@Getter
public enum ResponseCode {
   DEFAULT(200),                          // default success 200
   ERROR(-1),                             // diy error code -1
   ;

private final Integer code;

ResponseCode(Integer code) {
   this.code = code;
}

@Override
public String toString() {
   return code.toString();
}
}
