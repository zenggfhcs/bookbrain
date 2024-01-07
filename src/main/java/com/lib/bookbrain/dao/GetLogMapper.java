package com.lib.bookbrain.dao;

import com.lib.bookbrain.model.Payload;
import com.lib.bookbrain.model.log.GetLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yunxia
 */
@Mapper
public interface GetLogMapper extends BaseMapper<GetLog> {
GetLog getById(Payload<GetLog> payload);

List<GetLog> getBy(@Param("payload") Payload<GetLog> payload);

int create(Payload<GetLog> payload);

int update(Payload<GetLog> payload);

int delete(Payload<GetLog> payload);

GetLog getByUpdate(Payload<GetLog> payload);

}
