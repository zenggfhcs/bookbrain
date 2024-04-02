package com.lib.bookbrain.service;

import com.lib.bookbrain.model.entity.Book;
import com.lib.bookbrain.model.exchange.Payload;
import com.lib.bookbrain.model.exchange.Response;

public interface BookService extends BaseService<Book> {

@Override
Response create(Book entity);

@Override
Response getById(Integer id);

@Override
Response update(Payload<Book> payload);

@Override
Response delete(Integer id);
}
