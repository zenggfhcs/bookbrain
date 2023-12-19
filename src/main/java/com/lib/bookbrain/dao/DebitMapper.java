package com.lib.bookbrain.dao;

import com.lib.bookbrain.model.Debit;
import com.lib.bookbrain.model.Filter;
import com.lib.bookbrain.model.Payload;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DebitMapper extends BaseMapper<Debit> {
Debit getById(Payload<Debit> payload);

List<Debit> getBy(@Param("payload") Payload<Debit> payload, @Param("filter") Filter filter);

int create(Payload<Debit> payload);

int update(Payload<Debit> payload);

int delete(Payload<Debit> payload);

Debit getByUpdate(Payload<Debit> payload);
}
