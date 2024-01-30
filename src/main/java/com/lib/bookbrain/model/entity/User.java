package com.lib.bookbrain.model.entity;

import com.lib.bookbrain.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author yunxia
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {
/**
 * 用户 id
 */

private Integer id;
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
private String email;

/**
 * 用户电话号码
 */
private String phoneNumber;

/**
 * 状态聚合值
 */
private Integer condition;

/**
 * 权限聚合值
 */
private Long authority;
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


public static User DEFAULT = new User();

static {
   DEFAULT.setId(1);
   DEFAULT.setDisplayName("admin");
}

/*
public static boolean hasAuthority(int userAuthority, Authority authority) {
   return (userAuthority & authority.getValue()) != 0;
}

public static boolean isCondition(int userState, int state) {
   return (userState & state) != 0;
}

private static int set(int a, int local, int state) {
   // 此处没有对数据进行校验，如果不按照规则传数据，会出现意料之外的结果
   return a & (~local) | (local * state);
}

public static void checkAuthority(TokenBody tokenBody, Authority authority) {
   if (tokenBody != null && hasAuthority(tokenBody.getAuthority(), authority)) {
      return;
   }
   throw new MissPermissionException();
}

public void updateAuthority(Authority authority, State state) {
   this.authority = set(this.authority, authority.getValue(), state.getValue());
}

public void updateCondition(UserCondition condition, State state) {
   this.condition = set(this.condition, condition.getValue(), state.getValue());
}

 */
}
