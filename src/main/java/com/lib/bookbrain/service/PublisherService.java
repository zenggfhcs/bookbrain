package com.lib.bookbrain.service;

import com.lib.bookbrain.model.entity.Publisher;
import com.lib.bookbrain.model.exchange.FilterPayload;
import com.lib.bookbrain.model.exchange.Payload;
import com.lib.bookbrain.model.exchange.Response;
import com.lib.bookbrain.model.filter.PublisherFilter;

public interface PublisherService extends BaseService<Publisher, PublisherFilter> {
Response getBy(FilterPayload<Publisher, PublisherFilter> payload);

Response create(Payload<Publisher> payload);

Response getById(Payload<Publisher> payload);

Response update(Payload<Publisher> payload);

Response delete(Payload<Publisher> payload);
}
