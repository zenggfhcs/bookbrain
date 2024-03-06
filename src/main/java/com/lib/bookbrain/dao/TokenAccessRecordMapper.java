package com.lib.bookbrain.dao;

import com.lib.bookbrain.entity.TokenUsedRecord;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TokenAccessRecordMapper {
void updateByToken(String token);

int getByToken(String token);

void insert(TokenUsedRecord tur);
}
