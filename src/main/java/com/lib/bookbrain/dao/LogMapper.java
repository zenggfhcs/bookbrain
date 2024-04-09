package com.lib.bookbrain.dao;

import com.lib.bookbrain.model.entity.Log;
import com.lib.bookbrain.model.exchange.FilterPayload;
import com.lib.bookbrain.model.filter.LogFilter;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LogMapper extends BaseMapper<Log, LogFilter> {
void create(Log log);

void alter(Log log);

List<Log> filteredList(FilterPayload<Log, LogFilter> payload);

int getLengthByFilter(FilterPayload<Log, LogFilter> payload);
}
