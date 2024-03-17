package com.lib.bookbrain.model.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author yunxia
 */
@Getter
@Setter
public class User extends Entity {

/**
 * 用户 id
 */
private Integer id;

private Role role;

/**
 * 用户验证字符串
 */
private String authenticationString;

/**
 * 用户名
 */
private String displayName;

/**
 * 用户电话号码
 */
private String phoneNumber;

/**
 * 用户邮箱
 */
private String email;

/**
 * 姓
 */
private String surname;

/**
 * 名
 */
private String name;

/**
 * 年龄
 */
private Short age;

/**
 * 性别
 */
private Short gender;

/**
 * 出生日期
 */
private LocalDateTime birthday;

/**
 * 最后登录时间
 */
private LocalDateTime lastLoginTime;

private Audit auditInfo;

private static String renderDisplayName() {
	UUID uuid = UUID.randomUUID();
	String[] split = uuid.toString().split("-");
	return "书友" + Long.parseLong(split[split.length - 1], 16);
}

}
