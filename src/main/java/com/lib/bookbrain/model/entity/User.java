package com.lib.bookbrain.model.entity;

import com.lib.bookbrain.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private Short gender;

    /**
     * 年龄
     */
    private Short age;

}
