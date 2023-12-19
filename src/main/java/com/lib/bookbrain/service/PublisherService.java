package com.lib.bookbrain.service;

import com.lib.bookbrain.model.Filter;
import com.lib.bookbrain.model.Payload;
import com.lib.bookbrain.model.Publisher;
import com.lib.bookbrain.model.Response;

public interface PublisherService extends BaseService<Publisher> {
Response getBy(Payload<Publisher> payload, Filter filter);

Response create(Payload<Publisher> payload);

Response getById(Payload<Publisher> payload);

Response update(Payload<Publisher> payload);

Response delete(Payload<Publisher> payload);
}
