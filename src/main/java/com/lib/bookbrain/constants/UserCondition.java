package com.lib.bookbrain.constants;

import lombok.Getter;

/**
 * 用户状态
 */
@Getter
public enum UserCondition {
   /**
    * 已启用
    */
   IS_ENABLE(Value.v01),
   /**
    * 邮箱已验证
    */
   EMAIL_VERIFIED(Value.v02),
   /**
    * 电话号码已验证
    */
   PHONE_NUMBER_VERIFIED(Value.v03),
   ;

UserCondition(Integer value) {
   this.value = value;
}

private final Integer value;
}
