package com.lib.bookbrain.model.entity;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class TokenUsedRecord {

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


public static TokenUsedRecord generate() {
   return new TokenUsedRecord(null, null, null, null);
}
}
