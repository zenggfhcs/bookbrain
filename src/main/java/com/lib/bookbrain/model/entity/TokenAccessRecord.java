package com.lib.bookbrain.model.entity;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class TokenAccessRecord extends Entity {

/**
 * id
 */
private Integer id;

/**
 * 用户 id
 */
private Integer userId;

/**
 * token
 */
private String token;

/**
 * token 使用时间
 */
private LocalDateTime usedTime;

public static TokenAccessRecord generate() {
	return new TokenAccessRecord(null, null, null, null);
}
}
