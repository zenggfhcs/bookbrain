package com.lib.bookbrain.service;

import com.lib.bookbrain.model.Filter;
import com.lib.bookbrain.model.log.GetLog;
import com.lib.bookbrain.model.Payload;
import com.lib.bookbrain.model.Response;

public interface GetLogService extends BaseService<GetLog> {
void createLog(GetLog log);

void updateLogAfterReturn(GetLog log);

Response getBy(Payload<GetLog> payload, Filter filter);

Response create(Payload<GetLog> payload);

Response getById(Payload<GetLog> payload);

Response update(Payload<GetLog> payload);

Response delete(Payload<GetLog> payload);
}
