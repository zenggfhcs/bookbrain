package com.lib.bookbrain.constants;

import lombok.Getter;

@Getter
public enum Message {
   /**
    * 登录失败提示信息
    */
   LOGIN_FAILED("帐号或密码错误"),
   /**
    * token error
    */
   TOKEN_ERROR("token parsing(or create) error"),
   /**
    *
    */
   CREATE_ERROR("新建失败"),
   /**
    *
    */
   CREATE_DATA_ERROR("新建所需要的数据为空"),
   /**
    *
    */
   GET_ERROR("不存在"),
   /**
    *
    */
   UPDATE_DATA_ERROR("更新所需要的数据为空"),
   /**
    *
    */
   UPDATE_OLD_DATE_ERROR("旧数据异常"),
   /**
    *
    */
   UPDATE_ERROR("更新失败"),
   /**
    *
    */
   DELETE_DATA_ERROR("删除的对象似乎不存在"),
   /**
    *
    */
   DELETE_ERROR("删除失败"),
   /**
    *
    */
   MISS_PERMISSION("没有权限"),
   ;

private final String msg;

Message(String msg) {
   this.msg = msg;
}
}
