package com.lib.bookbrain.service;

import com.lib.bookbrain.model.Payload;
import com.lib.bookbrain.model.Response;
import com.lib.bookbrain.model.log.GetLog;

public interface GetLogService extends BaseService<GetLog> {
void createLog(GetLog log);

void updateLogAfterReturn(GetLog log);

Response getBy(Payload<GetLog> payload);

Response create(Payload<GetLog> payload);

Response getById(Payload<GetLog> payload);

Response update(Payload<GetLog> payload);

Response delete(Payload<GetLog> payload);
}
