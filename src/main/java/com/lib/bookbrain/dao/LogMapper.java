package com.lib.bookbrain.dao;

import com.lib.bookbrain.model.entity.Log;
import com.lib.bookbrain.model.exchange.Payload;
import com.lib.bookbrain.model.filter.LogFilter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LogMapper extends BaseMapper<Log, LogFilter> {
void create(Log log);

void alter(Log log);

List<Log> getBy(@Param("payload") Payload<Log> payload, @Param("filter") LogFilter filter);

int getCountByFilter(LogFilter filter);
}
