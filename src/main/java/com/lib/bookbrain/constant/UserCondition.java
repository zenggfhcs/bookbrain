package com.lib.bookbrain.constant;

import lombok.Getter;

/**
 * 用户状态枚举
 *
 * @author yunxia
 */
@Getter
public enum UserCondition {
   /**
    * 已启用 is_enable
    */
   IS_ENABLE(Value.i01),
   /**
    * 邮箱已验证 email_verified
    */
   EMAIL_VERIFIED(Value.i02),
   /**
    * 电话号码已验证 phone_number_verified
    */
   PHONE_NUMBER_VERIFIED(Value.i03),
   ;

private final Integer value;

UserCondition(Integer value) {
   this.value = value;
}
}
