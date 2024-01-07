package com.lib.bookbrain.constants;

import lombok.Getter;

/**
 * 用户权限枚举
 */
@Getter
public enum Authority {
   /**
    * 创建用户
    */
   USER_CREATE(Value.v01),
   /**
    *
    */
   USER_DELETE(Value.v02),
   /**
    *
    */
   USER_GET(Value.v03),
   /**
    *
    */
   USER_UPDATE(Value.v04),
   /**
    *
    */
   BOOK_CREATE(Value.v05),
   /**
    *
    */
   BOOK_DELETE(Value.v06),
   /**
    *
    */
   BOOK_GET(Value.v07),
   /**
    *
    */
   BOOK_UPDATE(Value.v08),
   /**
    *
    */
   BOOK_INFO_CREATE(Value.v09),
   /**
    *
    */
   
   BOOK_INFO_DELETE(Value.v10),
   /**
    *
    */
   BOOK_INFO_GET(Value.v11),
   /**
    *
    */
   BOOK_INFO_UPDATE(Value.v12),
   /**
    *
    */
   PUBLISHER_CREATE(Value.v13),
   /**
    *
    */
   PUBLISHER_DELETE(Value.v14),
   /**
    *
    */
   PUBLISHER_GET(Value.v15),
   /**
    *
    */
   PUBLISHER_UPDATE(Value.v16),
   /**
    *
    */
   DEBIT_CREATE(Value.v17),
   /**
    *
    */
   DEBIT_DELETE(Value.v18),
   /**
    *
    */
   DEBIT_GET(Value.v19),
   /**
    *
    */
   DEBIT_UPDATE(Value.v20),
   ;

private final Integer value;

Authority(Integer value) {
   this.value = value;
}
}
