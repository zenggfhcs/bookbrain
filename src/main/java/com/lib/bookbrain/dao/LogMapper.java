package com.lib.bookbrain.dao;

import com.lib.bookbrain.dto.filter.LogFilter;
import com.lib.bookbrain.entity.Log;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LogMapper extends BaseMapper<Log, LogFilter> {
void create(Log log);

void alter(Log log);
}
