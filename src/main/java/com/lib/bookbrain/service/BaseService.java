package com.lib.bookbrain.service;

import com.lib.bookbrain.model.entity.Entity;
import com.lib.bookbrain.model.exchange.Payload;
import com.lib.bookbrain.model.exchange.Response;

public interface BaseService<E extends Entity> {
Response list();
Response create(E entity);
Response getById(Integer id);
Response update(Payload<E> payload);
Response delete(Integer id);
}
