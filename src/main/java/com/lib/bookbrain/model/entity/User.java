package com.lib.bookbrain.model.entity;

import com.lib.bookbrain.constants.Authority;
import com.lib.bookbrain.constants.State;
import com.lib.bookbrain.constants.UserCondition;
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
 * 状态聚合值
 */
private Integer condition;

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
public static boolean hasAuthority(int userAuthority, Authority authority) {
   return (userAuthority & authority.getValue()) != 0;
}

/**
 * @param userState 用户状态值
 * @param state     状态类型
 * @return 状态检查结果
 */
public static boolean isCondition(int userState, int state) {
   return (userState & state) != 0;
}

private static int set(int a, int local, int condition) {
   return a & (~local) | (local * condition);
}

public void updateAuthority(Authority authority, State state) {
   this.authority = set(this.authority, authority.getValue(), state.getValue());
}

public void updateCondition(UserCondition condition, State state) {
   this.condition = set(this.condition, condition.getValue(), state.getValue());
}

}
