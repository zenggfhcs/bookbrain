package com.lib.bookbrain.constant;

import com.lib.bookbrain.utils.MyBean;

/**
 * Exception Enum
 *
 * @author yunxia
 */
public enum Error {

   /**
    * body（payload）缺失异常
    */
   PayloadMissException,

   /**
    * 权限缺失异常
    */
   PermissionMissException,

   /**
    * 更新错误异常
    */
   UpdateErrorException,
   ;

   /**
    * 由枚举的值生成一个异常，然后返回（之后被抛出）
    *
    * @return {@link RuntimeException} diy 的异常类对象
    */
   public RuntimeException generateError() {
      return MyBean.get(this.name(), RuntimeException.class);
   }
}
