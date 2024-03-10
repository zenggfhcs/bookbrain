package com.lib.bookbrain.dao;

import com.lib.bookbrain.model.entity.TokenAccessRecord;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TokenAccessRecordMapper {
void updateByToken(String token);

int getByToken(String token);

void insert(TokenAccessRecord tur);
}
