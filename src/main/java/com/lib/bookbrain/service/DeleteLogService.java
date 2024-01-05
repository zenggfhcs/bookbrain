package com.lib.bookbrain.service;

import com.lib.bookbrain.model.Payload;
import com.lib.bookbrain.model.Response;
import com.lib.bookbrain.model.log.DeletedLog;

public interface DeleteLogService extends BaseService<DeletedLog> {
void createLog(DeletedLog log);

void updateLog(DeletedLog log);

Response getBy(Payload<DeletedLog> payload);
@Override
Response create(Payload<DeletedLog> payload);
@Override
Response getById(Payload<DeletedLog> payload);
@Override
Response update(Payload<DeletedLog> payload);
@Override
Response delete(Payload<DeletedLog> payload);
}
