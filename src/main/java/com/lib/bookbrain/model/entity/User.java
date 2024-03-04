package com.lib.bookbrain.model.entity;

import com.lib.bookbrain.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

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
private String displayName = renderDisplayName();

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
private Integer condition = 2;

/**
 * 权限聚合值
 */
private Long authority = 111111111L;

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
private Short gender;

/**
 * 最后登录时间
 */
private LocalDateTime lastLoginTime;

/**
 * 出生日期
 */
private LocalDateTime birthday;
/**
 * 年龄
 */
private Short age;

private static String renderDisplayName() {
	UUID uuid = UUID.randomUUID();
	String[] split = uuid.toString().split("-");
	return "书友" + Long.parseLong(split[split.length - 1], 16);
}

public void init() {
}

}
