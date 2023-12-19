package com.lib.service;

import com.lib.model.*;

public interface BookService extends BaseService<Book> {
@Override
Response getBy(Payload<Book> payload, Filter filter);
@Override
Response create(Payload<Book> payload);
@Override
Response getById(Payload<Book> payload);
@Override
Response update(Payload<Book> payload);
@Override
Response delete(Payload<Book> payload);
}
