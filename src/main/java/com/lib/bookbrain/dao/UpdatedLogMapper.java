package com.lib.bookbrain.dao;

import com.lib.bookbrain.model.Filter;
import com.lib.bookbrain.model.Payload;
import com.lib.bookbrain.model.UpdatedLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UpdatedLogMapper extends BaseMapper<UpdatedLog> {
UpdatedLog getById(Payload<UpdatedLog> payload);

List<UpdatedLog> getBy(@Param("payload") Payload<UpdatedLog> payload, @Param("filter") Filter filter);

int create(Payload<UpdatedLog> payload);

int update(Payload<UpdatedLog> payload);

int delete(Payload<UpdatedLog> payload);

UpdatedLog getByUpdate(Payload<UpdatedLog> payload);
}
