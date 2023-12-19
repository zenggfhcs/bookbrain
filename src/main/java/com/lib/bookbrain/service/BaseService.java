package com.lib.service;

import com.lib.model.*;

public interface BaseService<T extends BaseEntity> {
Response getBy(Payload<T> payload, Filter filter);

Response create(Payload<T> payload);

Response getById(Payload<T> payload);

Response update(Payload<T> payload);

Response delete(Payload<T> payload);
}
