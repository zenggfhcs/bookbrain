package com.lib.bookbrain.service;

import com.lib.bookbrain.model.BaseEntity;
import com.lib.bookbrain.model.comm.Filter;
import com.lib.bookbrain.model.comm.FilterPayload;
import com.lib.bookbrain.model.comm.Payload;
import com.lib.bookbrain.model.comm.Response;

public interface BaseService<T extends BaseEntity, F extends Filter> {
    Response getBy(FilterPayload<T, F> payload);

    Response create(Payload<T> payload);

    Response getById(Payload<T> payload);

    Response update(Payload<T> payload);

    Response delete(Payload<T> payload);
}
