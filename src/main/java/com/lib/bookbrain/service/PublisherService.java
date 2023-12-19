package com.lib.service;

import com.lib.model.Payload;
import com.lib.model.Filter;
import com.lib.model.Publisher;
import com.lib.model.Response;

public interface PublisherService extends BaseService<Publisher> {
Response getBy(Payload<Publisher> payload, Filter filter);

Response create(Payload<Publisher> payload);

Response getById(Payload<Publisher> payload);

Response update(Payload<Publisher> payload);

Response delete(Payload<Publisher> payload);
}
