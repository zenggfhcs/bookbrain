package com.lib.bookbrain.dao;

import com.lib.bookbrain.model.comm.filters.LogFilter;
import com.lib.bookbrain.model.entity.Log;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LogMapper extends BaseMapper<Log, LogFilter> {
void create(Log log);

void alter(Log log);
}
