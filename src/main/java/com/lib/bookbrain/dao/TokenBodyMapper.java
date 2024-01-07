package com.lib.bookbrain.dao;

import com.lib.bookbrain.model.TokenBody;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TokenBodyMapper {
TokenBody getByToken(String token);
}
