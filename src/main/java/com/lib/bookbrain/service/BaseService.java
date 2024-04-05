package com.lib.bookbrain.service;

import com.lib.bookbrain.model.entity.Entity;
import com.lib.bookbrain.model.exchange.Payload;
import com.lib.bookbrain.model.exchange.Response;

public interface BaseService<E extends Entity> {
Response list();

Response create(Payload<E> payload);

Response getById(Payload<E> payload);

Response update(Payload<E> payload);

Response delete(Payload<E> payload);
}
