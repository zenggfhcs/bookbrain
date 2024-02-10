package com.lib.bookbrain.service;

import com.lib.bookbrain.model.dto.Payload;
import com.lib.bookbrain.model.dto.Response;
import com.lib.bookbrain.model.entity.Log;

public interface LogService extends BaseService<Log> {
@Override
Response getBy(Payload<Log> payload);

@Override
Response create(Payload<Log> payload);

@Override
Response getById(Payload<Log> payload);

@Override
Response update(Payload<Log> payload);

@Override
Response delete(Payload<Log> payload);
}
