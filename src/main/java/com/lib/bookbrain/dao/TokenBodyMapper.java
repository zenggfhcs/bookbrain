package com.lib.bookbrain.dao;

import com.lib.bookbrain.model.TokenBody;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author yunxia
 */
@Mapper
public interface TokenBodyMapper {
TokenBody getByToken(String token);
}
