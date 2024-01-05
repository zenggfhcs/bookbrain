package com.lib.bookbrain.dao;

import com.lib.bookbrain.model.log.DeletedLog;
import com.lib.bookbrain.model.Filter;
import com.lib.bookbrain.model.Payload;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DeletedLogMapper extends BaseMapper<DeletedLog> {
DeletedLog getById(Payload<DeletedLog> payload);

List<DeletedLog> getBy(@Param("payload") Payload<DeletedLog> payload, @Param("filter") Filter filter);

int create(Payload<DeletedLog> payload);

int update(Payload<DeletedLog> payload);

int delete(Payload<DeletedLog> payload);

DeletedLog getByUpdate(Payload<DeletedLog> payload);
}
