package com.lib.bookbrain.service;

import com.lib.bookbrain.model.BaseEntity;
import com.lib.bookbrain.model.Payload;
import com.lib.bookbrain.model.Response;

public interface BaseService<T extends BaseEntity> {
Response getBy(Payload<T> payload);

Response create(Payload<T> payload);

Response getById(Payload<T> payload);

Response update(Payload<T> payload);

Response delete(Payload<T> payload);
}
