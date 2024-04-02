package com.lib.bookbrain.service;

import com.lib.bookbrain.model.entity.Log;
import com.lib.bookbrain.model.exchange.Payload;
import com.lib.bookbrain.model.exchange.Response;

public interface LogService extends BaseService<Log> {

@Override
Response create(Log entity);

@Override
Response getById(Integer id);

@Override
Response update(Payload<Log> payload);

@Override
Response delete(Integer id);
}
