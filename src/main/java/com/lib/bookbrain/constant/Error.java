package com.lib.bookbrain.constant;

import com.lib.bookbrain.utils.MyBean;
import com.lib.bookbrain.utils.Parse;

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
   String _beanName = Parse.firstLower(this.name());
   return MyBean.get(_beanName, RuntimeException.class);
}
}
