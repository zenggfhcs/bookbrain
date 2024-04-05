package com.lib.bookbrain.service;

import com.lib.bookbrain.model.entity.Log;
import com.lib.bookbrain.model.exchange.Payload;
import com.lib.bookbrain.model.exchange.Response;

public interface LogService extends BaseService<Log> {

@Override
Response create(Payload<Log> payload);

@Override
Response getById(Payload<Log> payload);

@Override
Response update(Payload<Log> payload);

@Override
Response delete(Payload<Log> payload);
}
