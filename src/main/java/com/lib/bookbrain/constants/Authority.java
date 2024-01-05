package com.lib.bookbrain.constants;

import lombok.Getter;

/**
 * 用户权限枚举
 */
@Getter
public enum Authority {
   /**
    *
    */
   USER_CREATE(0B1),
   /**
    *
    */
   USER_DELETE(0B10),
   /**
    *
    */
   USER_SELECT(0B100),
   /**
    *
    */
   USER_UPDATE(0B1000),
   /**
    *
    */
   BOOK_CREATE(0B10000),
   /**
    *
    */
   BOOK_DELETE(0B100000),
   /**
    *
    */
   
   BOOK_SELECT(0B1000000),
   /**
    *
    */
   BOOK_UPDATE(0B10000000),
   /**
    *
    */
   BOOK_INFO_CREATE(0B100000000),
   /**
    *
    */
   
   BOOK_INFO_DELETE(0B1000000000),
   /**
    *
    */
   BOOK_INFO_SELECT(0B10000000000),
   /**
    *
    */
   BOOK_INFO_UPDATE(0B100000000000),
   /**
    *
    */
   
   PUBLISHER_CREATE(0B1000000000000),
   /**
    *
    */
   PUBLISHER_DELETE(0B10000000000000),
   /**
    *
    */
   PUBLISHER_SELECT(0B100000000000000),
   /**
    *
    */
   PUBLISHER_UPDATE(0B1000000000000000);

Authority(Integer value) {
   this.value = value;
}

private final Integer value;
}
