package com.lib.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {
/**
 * 用户 id
 */
private Integer userId;
/**
 * 用户验证字符串
 */
private String authenticationString;

/**
 * 用户名
 */
private String displayName;
/**
 * 用户邮箱
 */
private String userEmail;

/**
 * 用户电话号码
 */
private String userPhoneNumber;

/**
 * 已启用
 */
private Integer state;

/**
 * 权限聚合值
 */
private Integer authority;
/**
 * 姓
 */
private String surname;
/**
 * 名
 */
private String name;
/**
 * 性别
 */
private Short sex;
/**
 * 年龄
 */
private Short age;
/**
 * 最后登录时间
 */
private LocalDateTime lastLoginTime;

/**
 * @param userAuthority 用户权限值
 * @param authority     权限类型
 * @return 权限检查结果
 */
public static boolean hasAuthority(int userAuthority, int authority) {
   return (userAuthority & authority) != 0;
}

/**
 * @param userState 用户状态值
 * @param state     状态类型
 * @return 状态检查结果
 */
public static boolean isState(int userState, int state) {
   return (userState & state) != 0;
}

private static int set(int a, int local, int condition) {
   return a & (~local) | (local * condition);
}

public void updateAuthority(int authority, int condition) {
   this.authority = set(this.authority, authority, condition);
}

public void updateState(int state, int condition) {
   this.state = set(this.state, state, condition);
}

/**
 * 权限静态类
 */
public static final class Authority {
   public static final int USER_CREATE = 0B1;
   public static final int USER_DELETE = 0B10;
   public static final int USER_SELECT = 0B100;
   public static final int USER_UPDATE = 0B1000;
   public static final int BOOK_CREATE = 0B10000;
   public static final int BOOK_DELETE = 0B100000;
   public static final int BOOK_SELECT = 0B1000000;
   public static final int BOOK_UPDATE = 0B10000000;
   public static final int BOOK_INFO_CREATE = 0B100000000;
   public static final int BOOK_INFO_DELETE = 0B1000000000;
   public static final int BOOK_INFO_SELECT = 0B10000000000;
   public static final int BOOK_INFO_UPDATE = 0B100000000000;
   public static final int PUBLISHER_CREATE = 0B1000000000000;
   public static final int PUBLISHER_DELETE = 0B10000000000000;
   public static final int PUBLISHER_SELECT = 0B100000000000000;
   public static final int PUBLISHER_UPDATE = 0B1000000000000000;
}

/**
 * 状态静态类
 */
public static final class State {
   /**
    * 已删除
    */
   public static final int IS_DELETE = 0b1;
   /**
    * 已启用
    */
   public static final int IS_ENABLE = 0b10;
   /**
    * 邮箱已验证
    */
   public static final int EMAIL_VERIFIED = 0b100;
   /**
    * 电话号码已验证
    */
   public static final int PHONE_NUMBER_VERIFIED = 0b1000;
   
}

/**
 * 状态类：开还是关
 */
public static final class Condition {
   /**
    * 关
    */
   public static final int DISABLE = 0b0;
   /**
    * 开
    */
   public static final int ENABLE = 0b1;
}

}
