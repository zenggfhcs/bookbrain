package com.lib.bookbrain.constants;

import lombok.Getter;

/**
 * 用户状态枚举
 *
 * @author yunxia
 */
@Getter
public enum UserCondition {
   /**
    * 已启用
    */
   IS_ENABLE(Value.i01),
   /**
    * 邮箱已验证
    */
   EMAIL_VERIFIED(Value.i02),
   /**
    * 电话号码已验证
    */
   PHONE_NUMBER_VERIFIED(Value.i03),
   ;

private final Integer value;

UserCondition(Integer value) {
   this.value = value;
}
}
