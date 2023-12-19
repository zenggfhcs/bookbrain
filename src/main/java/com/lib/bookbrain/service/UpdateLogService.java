package com.lib.bookbrain.service;

import com.lib.bookbrain.model.*;

public interface UpdateLogService extends BaseService<UpdatedLog> {
void createLog(UpdatedLog log);

void updateLog(UpdatedLog log);

Response getBy(Payload<UpdatedLog> payload, Filter filter);

Response create(Payload<UpdatedLog> payload);

Response getById(Payload<UpdatedLog> payload);

Response update(Payload<UpdatedLog> payload);

Response delete(Payload<UpdatedLog> payload);
}
