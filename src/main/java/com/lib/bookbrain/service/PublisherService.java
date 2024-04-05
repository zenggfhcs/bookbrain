package com.lib.bookbrain.service;

import com.lib.bookbrain.model.entity.Publisher;
import com.lib.bookbrain.model.exchange.Payload;
import com.lib.bookbrain.model.exchange.Response;

public interface PublisherService extends BaseService<Publisher> {
Response create(Payload<Publisher> payload);

Response getById(Payload<Publisher> payload);

Response update(Payload<Publisher> payload);

Response delete(Payload<Publisher> payload);
}
