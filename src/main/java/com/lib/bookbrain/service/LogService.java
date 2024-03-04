package com.lib.bookbrain.service;

import com.lib.bookbrain.model.comm.FilterPayload;
import com.lib.bookbrain.model.comm.Payload;
import com.lib.bookbrain.model.comm.Response;
import com.lib.bookbrain.model.comm.filters.LogFilter;
import com.lib.bookbrain.model.entity.Log;

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
