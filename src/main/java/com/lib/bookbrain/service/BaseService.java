package com.lib.bookbrain.service;

import com.lib.bookbrain.dto.FilterPayload;
import com.lib.bookbrain.dto.Payload;
import com.lib.bookbrain.dto.Response;
import com.lib.bookbrain.dto.filter.BaseFilter;
import com.lib.bookbrain.entity.BaseEntity;

public interface BaseService<T extends BaseEntity, F extends BaseFilter> {
Response getBy(FilterPayload<T, F> payload);

Response create(Payload<T> payload);

Response getById(Payload<T> payload);

Response update(Payload<T> payload);

Response delete(Payload<T> payload);
}
