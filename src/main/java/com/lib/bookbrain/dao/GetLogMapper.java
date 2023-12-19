package com.lib.dao;

import com.lib.model.Filter;
import com.lib.model.GetLog;
import com.lib.model.Payload;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GetLogMapper extends BaseMapper<GetLog> {
GetLog getById(Payload<GetLog> payload);

List<GetLog> getBy(@Param("payload") Payload<GetLog> payload, @Param("filter") Filter filter);

int create(Payload<GetLog> payload);

int update(Payload<GetLog> payload);

int delete(Payload<GetLog> payload);

GetLog getByUpdate(Payload<GetLog> payload);

}
