package com.lib.bookbrain.constants;

import lombok.Getter;

/**
 * 用户状态枚举
 *
 * @author yunxia
 */
@Getter
public enum UserCondition {
   IS_ENABLE(Value.i01),                  // 已启用 is_enable

   EMAIL_VERIFIED(Value.i02),             // 邮箱已验证 email_verified

   PHONE_NUMBER_VERIFIED(Value.i03),      // 电话号码已验证 phone_number_verified
   ;

private final Integer value;

UserCondition(Integer value) {
   this.value = value;
}
}
