package com.lib.bookbrain.constants;

import lombok.Getter;

/**
 * 用户权限枚举
 *
 * @author yunxia
 */
@Getter
public enum Authority {
   /**
    * 创建用户
    */
   USER_CREATE(Value.i01),
   /**
    * 删除用户
    */
   USER_DELETE(Value.i02),
   /**
    *
    */
   USER_GET(Value.i03),
   /**
    *
    */
   USER_UPDATE(Value.i04),
   /**
    *
    */
   BOOK_CREATE(Value.i05),
   /**
    *
    */
   BOOK_DELETE(Value.i06),
   /**
    *
    */
   BOOK_GET(Value.i07),
   /**
    *
    */
   BOOK_UPDATE(Value.i08),
   /**
    *
    */
   BOOK_INFO_CREATE(Value.i09),
   /**
    *
    */
   
   BOOK_INFO_DELETE(Value.i10),
   /**
    *
    */
   BOOK_INFO_GET(Value.i11),
   /**
    *
    */
   BOOK_INFO_UPDATE(Value.i12),
   /**
    *
    */
   PUBLISHER_CREATE(Value.i13),
   /**
    *
    */
   PUBLISHER_DELETE(Value.i14),
   /**
    *
    */
   PUBLISHER_GET(Value.i15),
   /**
    *
    */
   PUBLISHER_UPDATE(Value.i16),
   /**
    *
    */
   DEBIT_CREATE(Value.i17),
   /**
    *
    */
   DEBIT_DELETE(Value.i18),
   /**
    *
    */
   DEBIT_GET(Value.i19),
   /**
    *
    */
   DEBIT_UPDATE(Value.i20),
   ;

private final Integer value;

Authority(Integer value) {
   this.value = value;
}
}
