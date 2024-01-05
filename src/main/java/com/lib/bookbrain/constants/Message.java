package com.lib.bookbrain.constants;

import lombok.Getter;

@Getter
public enum Message {
   /**
    * 登录失败提示信息
    */
   LOGIN_FAILED(""),
   /**
    * token error
    */
   TOKEN_ERROR("token parsing(or create) error")
   ;

Message(String msg) {
   this.msg = msg;
}

private final String msg;
}
