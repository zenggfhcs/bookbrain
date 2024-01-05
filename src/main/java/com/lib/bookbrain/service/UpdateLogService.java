package com.lib.bookbrain.service;

import com.lib.bookbrain.model.Payload;
import com.lib.bookbrain.model.Response;
import com.lib.bookbrain.model.log.UpdatedLog;

public interface UpdateLogService extends BaseService<UpdatedLog> {
void createLog(UpdatedLog log);

void updateLog(UpdatedLog log);

Response getBy(Payload<UpdatedLog> payload);

Response create(Payload<UpdatedLog> payload);

Response getById(Payload<UpdatedLog> payload);

Response update(Payload<UpdatedLog> payload);

Response delete(Payload<UpdatedLog> payload);
}
