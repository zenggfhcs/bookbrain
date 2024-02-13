package com.lib.bookbrain.constant;

import com.lib.bookbrain.model.comm.BaseResponseInfo;
import lombok.Getter;

@Getter
public enum ResponseInfo {
   
   /**
    *
    */
   SUCCESS(200, ""),
   
   /**
    * 登录失败提示信息：用户名或者密码错误
    */
   LOGIN_FAILED("Username or password error"),
   
   /**
    * token 创建或者解析时异常
    */
   TOKEN_ERROR("Token error"),
   
   /**
    *
    */
   CREATE_ERROR("Creation failed"),
   
   /**
    *
    */
   CREATE_DATA_ERROR("The data required to create a new one is empty"),
   
   /**
    *
    */
   GET_ERROR("The data does not exist"),
   
   /**
    *
    */
   UPDATE_DATA_ERROR("The data required for update is empty"),
   
   /**
    *
    */
   UPDATE_OLD_DATE_ERROR("The data to be updated is empty"),
   
   /**
    *
    */
   UPDATE_ERROR("Update failed"),
   
   /**
    *
    */
   DELETE_DATA_ERROR("The data to be deleted is empty"),
   
   /**
    *
    */
   DELETE_ERROR("Delete error"),
   
   /**
    *
    */
   MISS_PERMISSION("Delete failed"),
   
   /**
    *
    */
   SQL_EXEC_ERROR("Sql execution failed"),
   ;

private final BaseResponseInfo info;

ResponseInfo(BaseResponseInfo info) {
   this.info = info;
}

ResponseInfo(Integer code, String msg) {
   this.info = BaseResponseInfo.builder()
         .message(msg)
         .code(code)
         .build();
}

ResponseInfo(String msg) {
   this(-1, msg);
}
}
