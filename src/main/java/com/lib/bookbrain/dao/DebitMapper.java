package com.lib.bookbrain.dao;

import com.lib.bookbrain.model.Payload;
import com.lib.bookbrain.model.entity.Debit;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yunxia
 */
@Mapper
public interface DebitMapper extends BaseMapper<Debit> {
Debit getById(Payload<Debit> payload);

List<Debit> getBy(@Param("payload") Payload<Debit> payload);

int insert(Payload<Debit> payload);

int update(Payload<Debit> payload);

int delete(Payload<Debit> payload);

Debit getByUpdate(Payload<Debit> payload);
}
