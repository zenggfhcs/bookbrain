package com.lib.bookbrain.service;

import com.lib.bookbrain.dto.FilterPayload;
import com.lib.bookbrain.dto.Payload;
import com.lib.bookbrain.dto.Response;
import com.lib.bookbrain.dto.filter.LogFilter;
import com.lib.bookbrain.entity.Log;

public interface LogService extends BaseService<Log, LogFilter> {
@Override
Response getBy(FilterPayload<Log, LogFilter> payload);

@Override
Response create(Payload<Log> payload);

@Override
Response getById(Payload<Log> payload);

@Override
Response update(Payload<Log> payload);

@Override
Response delete(Payload<Log> payload);
}
