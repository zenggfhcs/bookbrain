package com.lib.bookbrain.service;

import com.lib.bookbrain.model.entity.Log;
import com.lib.bookbrain.model.exchange.FilterPayload;
import com.lib.bookbrain.model.exchange.Payload;
import com.lib.bookbrain.model.exchange.Response;
import com.lib.bookbrain.model.filter.LogFilter;

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
