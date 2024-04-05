package com.lib.bookbrain.service;

import com.lib.bookbrain.model.entity.Book;
import com.lib.bookbrain.model.exchange.Payload;
import com.lib.bookbrain.model.exchange.Response;

public interface BookService extends BaseService<Book> {

@Override
Response create(Payload<Book> payload);

@Override
Response getById(Payload<Book> payload);

@Override
Response update(Payload<Book> payload);

@Override
Response delete(Payload<Book> payload);
}
