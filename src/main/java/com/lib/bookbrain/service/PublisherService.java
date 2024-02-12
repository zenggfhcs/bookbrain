package com.lib.bookbrain.service;

import com.lib.bookbrain.model.comm.Payload;
import com.lib.bookbrain.model.comm.Response;
import com.lib.bookbrain.model.entity.Publisher;

public interface PublisherService extends BaseService<Publisher> {
Response getBy(Payload<Publisher> payload);

Response create(Payload<Publisher> payload);

Response getById(Payload<Publisher> payload);

Response update(Payload<Publisher> payload);

Response delete(Payload<Publisher> payload);
}
