package com.lib.bookbrain.model.pojo;

import lombok.Data;

@Data
public class Condition {
/**
 * id
 */
private Integer id;
/**
 * 已启用
 */
private Boolean isEnable;
/**
 * 邮箱已验证
 */
private Boolean emailVerified;
/**
 * 手机号码验证
 */
private Boolean phoneNumberVerified;
}
