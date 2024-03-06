package com.lib.bookbrain.service;

import com.lib.bookbrain.dto.FilterPayload;
import com.lib.bookbrain.dto.Payload;
import com.lib.bookbrain.dto.Response;
import com.lib.bookbrain.dto.filter.BookFilter;
import com.lib.bookbrain.entity.Book;

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
