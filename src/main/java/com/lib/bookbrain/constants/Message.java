package com.lib.bookbrain.constants;

import lombok.Getter;

/**
 * 响应消息枚举
 *
 * @author yunxia
 */
@Getter
public enum Message {
   LOGIN_FAILED("Username or password error"),                             // 登录失败提示信息：用户名或者密码错误

   TOKEN_ERROR("Token error"),                                             // token 创建或者解析时发生错误

   CREATE_ERROR("Creation failed"),                                        //

   CREATE_DATA_ERROR("The data required to create a new one is empty"),    //

   GET_ERROR("The data does not exist"),                                   //

   UPDATE_DATA_ERROR("The data required for update is empty"),             //

   UPDATE_OLD_DATE_ERROR("The data to be updated is empty"),               //

   UPDATE_ERROR("Update failed"),                                          //

   DELETE_DATA_ERROR("The data to be deleted is empty"),                   //

   DELETE_ERROR("Delete error"),                                           //

   MISS_PERMISSION("Delete failed"),                                       //

   SQL_RUN_ERROR("Sql execution failed"),                                  //

   ;
private final String msg;

Message(String msg) {
   this.msg = msg;
}
}
