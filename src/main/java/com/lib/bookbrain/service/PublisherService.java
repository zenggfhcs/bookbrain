package com.lib.bookbrain.service;

import com.lib.bookbrain.model.comm.FilterPayload;
import com.lib.bookbrain.model.comm.Payload;
import com.lib.bookbrain.model.comm.Response;
import com.lib.bookbrain.model.comm.filters.PublisherFilter;
import com.lib.bookbrain.model.entity.Publisher;

public interface PublisherService extends BaseService<Publisher, PublisherFilter> {
Response getBy(FilterPayload<Publisher, PublisherFilter> payload);

Response create(Payload<Publisher> payload);

Response getById(Payload<Publisher> payload);

Response update(Payload<Publisher> payload);

Response delete(Payload<Publisher> payload);
}
