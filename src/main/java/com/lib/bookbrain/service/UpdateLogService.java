package com.lib.service;

import com.lib.model.*;

public interface UpdateLogService extends BaseService<UpdatedLog> {
void createLog(UpdatedLog log);

void updateLog(UpdatedLog log);

Response getBy(Payload<UpdatedLog> payload, Filter filter);

Response create(Payload<UpdatedLog> payload);

Response getById(Payload<UpdatedLog> payload);

Response update(Payload<UpdatedLog> payload);

Response delete(Payload<UpdatedLog> payload);
}
