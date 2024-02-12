package com.lib.bookbrain.service;

import com.lib.bookbrain.model.comm.Payload;
import com.lib.bookbrain.model.comm.Response;
import com.lib.bookbrain.model.entity.Book;

public interface BookService extends BaseService<Book> {
@Override
Response getBy(Payload<Book> payload);

@Override
Response create(Payload<Book> payload);

@Override
Response getById(Payload<Book> payload);

@Override
Response update(Payload<Book> payload);

@Override
Response delete(Payload<Book> payload);
}
