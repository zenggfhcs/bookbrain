package com.lib.bookbrain.service;

import com.lib.bookbrain.model.entity.Entity;
import com.lib.bookbrain.model.exchange.FilterPayload;
import com.lib.bookbrain.model.exchange.Payload;
import com.lib.bookbrain.model.exchange.Response;
import com.lib.bookbrain.model.filter.BaseFilter;

public interface BaseService<E extends Entity, F extends BaseFilter> {
Response getBy(FilterPayload<E, F> payload);

Response create(Payload<E> payload);

Response getById(Payload<E> payload);

Response update(Payload<E> payload);

Response delete(Payload<E> payload);
}
