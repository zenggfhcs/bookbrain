package com.lib.bookbrain.constants;

import com.lib.bookbrain.exception.PayloadMissException;
import com.lib.bookbrain.exception.PermissionMissException;
import com.lib.bookbrain.exception.UpdateErrorException;

/**
 * Exception Enum
 *
 * @author i
 */
public enum EException {
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
public RuntimeException generateExp() {
   return switch (this) {
      case PayloadMissException -> new PayloadMissException();
      case PermissionMissException -> new PermissionMissException();
      case UpdateErrorException -> new UpdateErrorException();
   };
}
}
