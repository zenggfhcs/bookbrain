package com.lib.bookbrain.model.entity;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class TokenUsedRecord {
private Integer id;
private Integer userId;
private String token;
private LocalDateTime usedTime;

public static TokenUsedRecord generate() {
   return new TokenUsedRecord(null, null, null, null);
}
}
