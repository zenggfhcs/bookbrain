package com.lib.bookbrain.constants;

import lombok.Getter;

/**
 * 用户权限枚举
 *
 * @author yunxia
 */
@Getter
public enum Authority {
   /* -------- user -------- */
   USER_CREATE(Value.i01),                         // 创建
   USER_DELETE(Value.i02),                         // 删除
   USER_GET(Value.i03),                            // 获取
   USER_UPDATE(Value.i04),                         // 更新
   /* -------- user -------- */

   /* -------- book -------- */
   BOOK_CREATE(Value.i05),                         // 创建
   BOOK_DELETE(Value.i06),                         // 删除
   BOOK_GET(Value.i07),                            // 获取
   BOOK_UPDATE(Value.i08),                         // 更新
   /* -------- book -------- */

   /* -------- book info -------- */
   BOOK_INFO_CREATE(Value.i09),                    // 创建
   BOOK_INFO_DELETE(Value.i10),                    // 删除
   BOOK_INFO_GET(Value.i11),                       // 获取
   BOOK_INFO_UPDATE(Value.i12),                    // 更新
   /* -------- book info -------- */

   /* -------- publisher -------- */
   PUBLISHER_CREATE(Value.i13),                    // 创建
   PUBLISHER_DELETE(Value.i14),                    // 删除
   PUBLISHER_GET(Value.i15),                       // 获取
   PUBLISHER_UPDATE(Value.i16),                    // 更新
   /* -------- publisher -------- */

   /* -------- debit -------- */
   DEBIT_CREATE(Value.i17),                        // 创建
   DEBIT_DELETE(Value.i18),                        // 删除
   DEBIT_GET(Value.i19),                           // 获取
   DEBIT_UPDATE(Value.i20),                        // 更新
   /* -------- debit -------- */
   ;

private final Integer value;

Authority(Integer value) {
   this.value = value;
}
}
