package com.lib.bookbrain.service;

import com.lib.bookbrain.dto.FilterPayload;
import com.lib.bookbrain.dto.Payload;
import com.lib.bookbrain.dto.Response;
import com.lib.bookbrain.dto.filter.PublisherFilter;
import com.lib.bookbrain.entity.Publisher;

public interface PublisherService extends BaseService<Publisher, PublisherFilter> {
Response getBy(FilterPayload<Publisher, PublisherFilter> payload);

Response create(Payload<Publisher> payload);

Response getById(Payload<Publisher> payload);

Response update(Payload<Publisher> payload);

Response delete(Payload<Publisher> payload);
}
