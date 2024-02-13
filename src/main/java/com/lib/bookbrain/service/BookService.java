package com.lib.bookbrain.service;

import com.lib.bookbrain.model.comm.FilterPayload;
import com.lib.bookbrain.model.comm.Payload;
import com.lib.bookbrain.model.comm.Response;
import com.lib.bookbrain.model.comm.filters.BookFilter;
import com.lib.bookbrain.model.entity.Book;

public interface BookService extends BaseService<Book, BookFilter> {
@Override
Response getBy(FilterPayload<Book, BookFilter> payload);

@Override
Response create(Payload<Book> payload);

@Override
Response getById(Payload<Book> payload);

@Override
Response update(Payload<Book> payload);

@Override
Response delete(Payload<Book> payload);
}
